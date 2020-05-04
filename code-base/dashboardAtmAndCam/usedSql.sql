

--used to get the seconds in event_end_adj - event_start_adj
SELECT EXTRACT(EPOCH FROM (SELECT event_end_adj FROM dashboard.event WHERE terminal_id = '07007001')::timestamp - (SELECT event_start_adj FROM dashboard.event WHERE terminal_id = '07007001')::timestamp) AS seconds

--used to get the date
SELECT event_start_adj::TIMESTAMP::DATE FROM dashboard.event WHERE terminal_id = '07007001'

--used to get the time only
SELECT	event_start_adj::TIMESTAMP::TIME FROM dashboard.event WHERE terminal_id = '07007001'

--used to UPDATE down_event table
--note to UPDATE will experiment on INSERT once event_start_adj and event_end_adj on event table is populated
UPDATE dashboard.down_event SET down_date = (SELECT event_start_adj::TIMESTAMP::DATE FROM dashboard.event WHERE terminal_id = '07007001'), down_duration_sec = (SELECT EXTRACT(EPOCH FROM(SELECT event_end_adj FROM dashboard.event WHERE terminal_id='07007001')::timestamp - (SELECT event_start_adj FROM dashboard.event WHERE terminal_id = '07007001')::timestamp)),
down_time = (SELECT	event_start_adj::TIMESTAMP::TIME FROM dashboard.event WHERE terminal_id = '07007001')

--get all the data that is UNPLANNED AND DOWN where the machine_type is 'CAM'
SELECT * FROM dashboard.event WHERE terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM') AND PLANNED = 'UNPLANNED' AND event_status = 'DOWN'

--query to update event_star_time and event_end_time = to event_start_adj and event_end_adj
UPDATE dashboard.event SET event_start_time = event_start_adj, event_end_time = event_end_adj WHERE terminal_ID in (SELECT terminal_id FROM dashboard.inventory)

--QUERY to get the minutes(event_end_adj - event_start_adj)
UPDATE dashboard.event SET event_duration_mins = (DATE_PART('day', event_end_adj::timestamp - event_start_adj::timestamp) * 24 + 
               DATE_PART('hour', event_end_adj::timestamp - event_start_adj::timestamp)) * 60 +
               DATE_PART('minute', event_end_adj::timestamp - event_start_adj::timestamp);

--CREATES TABLE dashboard.event
CREATE TABLE dashboard.event
(
    event_id SERIAL,
    terminal_id character varying(8),
    event_status character varying(4),
    event_start_time timestamp without time zone,
    event_end_time timestamp without time zone,
    event_start_adj timestamp without time zone,
    event_end_adj timestamp without time zone,
    event_description character varying(90),
    event_duration_mins double precision,
    operation_start_time time without time zone,
    operation_end_time time without time zone,
    planned character varying(10),
    CONSTRAINT event_pkey PRIMARY KEY (event_id),
    FOREIGN KEY(terminal_id) REFERENCES dashboard.inventory(terminal_id)
)
--used to insert random pk from inventory table to event table
INSERT into dashboard.event (terminal_id) 
SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM' ORDER BY random() limit 1000

--randomizer to input/update data in the table via randomizing it
UPDATE dashboard.event de
SET event_description = (array['CAM OUT OF SERVICE', 'CAM BEING SERVICE', 'NETWORK CONNECTION LOST', 'BLACKSCREEN', 'BNA DEVICE ERROR', 'POSSIBLE COMMUNICATION KEY ERROR ON CAM', 'POSSIBLE TAMPERING', 'CARD READER ERROR', 'CASH ACCEPT BIN FATAL', 'CASH ACCEPT BIN ERROR'])[(random() * 9 + 1)::int] WHERE de.terminal_id IN (SELECT di.terminal_id FROM dashboard.inventory di WHERE di.machine_type = 'CAM');

--randomizer to event_status data in the table via randomizing it
UPDATE dashboard.event de
SET event_description = (array['UP', 'DOWN'])[(random() * 1 + 1)::int] WHERE de.terminal_id IN (SELECT di.terminal_id FROM dashboard.inventory di WHERE di.machine_type = 'CAM');

--code to use populate date on event_start_adj
UPDATE dashboard.event SET event_start_adj = '2020-01-01  00:00:00'::timestamp + date_trunc('second',(random() * ('2020-04-16 23:59:59'::timestamp - '2020-01-01 00:00:00'::timestamp)))

--update the event_end_adj in the interval of 1 hour between the event_start_adj and event_end_adj
UPDATE dashboard.event SET event_end_adj = event_start_adj + make_interval(mins => (random() * 59)::int)

--used to set operation_start and operation_end of inventory table to the operation_start_time and operation_end_time of event table
UPDATE dashboard.event e
    SET operation_start_time = i.operation_start,
        operation_end_time = i.operation_end
    FROM dashboard.inventory i
    WHERE e.terminal_id = i.terminal_id;

-- used to update the event_duration_mins
UPDATE dashboard.event SET event_duration_mins = (DATE_PART('day', event_end_adj::timestamp - event_start_adj::timestamp) * 24 + 
               DATE_PART('hour', event_end_adj::timestamp - event_start_adj::timestamp)) * 60 +
               DATE_PART('minute', event_end_adj::timestamp - event_start_adj::timestamp);

--CREATES TABLE dashboard.down_event
CREATE TABLE dashboard.down_event
(
    id SERIAL,
    terminal_id character varying(8),
    event_description character varying(90),
    down_date date,
    down_time time without time zone,
    down_duration_sec double precision
)
--CODE to insert all the needed data for the down_event table
INSERT INTO dashboard.down_event(terminal_id, event_description, down_date, down_time, down_duration_sec)
SELECT terminal_id, event_description,
       event_start_adj::TIMESTAMP::DATE AS date, 
       event_start_adj::TIMESTAMP::TIME AS time,
       (EXTRACT(EPOCH FROM event_end_adj::TIMESTAMP) -
        EXTRACT(EPOCH FROM event_start_adj::TIMESTAMP)
       ) AS seconds
FROM dashboard.event
WHERE event_status = 'DOWN' AND planned = 'UNPLANNED'

--CREATES TABLE dashboard.availability
CREATE TABLE dashboard.availability
(
    terminal_id character varying(8),
    availability_date date,
    availability_time time without time zone,
    duration_sec numeric(8,2),
    availability_percentage numeric(8,2),
    in_opt_hrs boolean,
    CONSTRAINT availability_pkey PRIMARY KEY (terminal_id, availability_date, availability_time)
)

--INSERT THE terminal_id, availability_date, availability_time (3 PKs) inside the availability table
INSERT INTO dashboard.availability(terminal_id, availability_date, availability_time)
select td.terminal_id, generate_series(
           (date '2020-01-01')::date,
           (date '2020-04-15')::date,
           interval '1 day'
         ), (hh * interval '1 hour')::time
from (select distinct terminal_id
      from dashboard.inventory where machine_type = 'CAM'
     ) td cross join
     generate_series(0, 23) gs(hh);

-- UPDATES the duration_sec, availability_percentage, in_opt_hrs
UPDATE dashboard.availability SET duration_sec = 3600, availability_percentage = 100, in_opt_hrs = TRUE

--UPDATES the duration_sec of every 1 hour that has down time
UPDATE dashboard.availability 
SET duration_sec = 3600 - t.down_duration_sec
FROM (  
    SELECT down_duration_sec, down_date, terminal_id, down_time
    FROM dashboard.down_event 
    WHERE terminal_id IN (SELECT terminal_id FROM dashboard.dummy)
    GROUP BY down_duration_sec, down_date, terminal_id, down_time
) t 
WHERE t.terminal_id = dashboard.availability.terminal_id
AND dashboard.availability.availability_date = t.down_date
AND t.down_time BETWEEN dashboard.availability.availability_time AND dashboard.availability.availability_time + interval '1 hour'

--UPDATES THE availability_percentage
UPDATE dashboard.availability dd
SET availability_percentage = ROUND((((3600 - t.down_duration_sec) /3600) * 100)::numeric, 2)
FROM(
	SELECT terminal_id, down_duration_sec, down_date FROM dashboard.down_event WHERE terminal_id IN (SELECT terminal_id FROM dashboard.dummy) GROUP BY terminal_id, down_duration_sec, down_date
)t
WHERE dd.duration_sec < 3600
AND dd.availability_date = t.down_date
AND dd.terminal_id = t.terminal_id