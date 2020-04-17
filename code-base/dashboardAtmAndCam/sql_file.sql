UPDATE dashboard.inventory
    SET operation_start = '00:00:00' + floor((random() * 23*60*60)) * interval '1 second',
        update_date = NOW()
		
UPDATE dashboard.inventory
    SET operation_end = operation_start + interval '4 hour'
	
SELECT operation_start, operation_end FROM dashboard.inventory

SELECT terminal_id, machine_name, machine_type FROM dashboard.inventory  WHERE machine_type = 'CAM'

ALTER TABLE dashboard.event ADD COLUMN terminal_id varchar(8)

ALTER TABLE dashboard.event ADD CONSTRAINT terminal_id FOREIGN KEY (terminal_id) REFERENCES dashboard.inventory(terminal_id);

ALTER TABLE dashboard.event MODIFY event_id INT AUTO_INCREMENT

INSERT INTO dashboard.event(terminal_id) VALUES ('00010011')
SELECT * FROM dashboard.event

ALTER SEQUENCE RESTART owned by dashboard.event

INSERT INTO dashboard.event(terminal_id)
SELECT terminal_id FROM dashboard.inventory

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
    operation_start_time timestamp without time zone,
    operation_end_time timestamp without time zone,
    planned character varying(10),
    CONSTRAINT event_pkey PRIMARY KEY (event_id),
    FOREIGN KEY(terminal_id) REFERENCES dashboard.inventory(terminal_id)
)

select * FROM dashboard.event WHERE terminal_id = '30580100'

SELECT de.terminal_id , de.event_description FROM dashboard.event de WHERE de.terminal_id IN (
SELECT di.terminal_id FROM dashboard.inventory di WHERE di.machine_type = 'CAM')

SELECT terminal_id, COUNT(*) FROM dashboard.event group by terminal_id
SELECT event_description, COUNT(*) FROM dashboard.event group by event_description
SELECT * FROM dashboard.event
SELECT count(event_description)FROM dashboard.event

DELETE FROM dashboard.event WHERE terminal_id is null;

SELECT terminal_id, machine_name, machine_type, operation_start, operation_end FROM dashboard.inventory

UPDATE dashboard.event de
SET event_description = (array['CAM OUT OF SERVICE', 'CAM BEING SERVICE', 'NETWORK CONNECTION LOST', 'BLACKSCREEN', 'BNA DEVICE ERROR'])[(random() * 4 + 1)::int] WHERE de.terminal_id IN (SELECT di.terminal_id FROM dashboard.inventory di WHERE di.machine_type = 'CAM');

UPDATE dashboard.event 
SET event_status = (array['UP', 'DOWN'])[(random() * 1 + 1)::int];

SELECT event_description, COUNT(*) AS error_count FROM dashboard.event WHERE terminal_id IN(
	SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM'
) GROUP by event_description ORDER by error_count DESC

UPDATE dashboard.event de SET de.operation_start_time = (SELECT operation_start FROM dashboard.inventory WHERE de.terminal_id = ), de.operation_end_time = (SELECT operation_end FROM dashboard.inventory) WHERE terminal_id IN (SELECT terminal_id FROM dashboard.inventory)


SELECT event_description, COUNT(*) AS error_count FROM dashboard.event WHERE terminal_id IN(
	SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM'
) GROUP by event_description ORDER by error_count DESC

UPDATE dashboard.event de SET de.operation_start_time = (SELECT operation_start FROM dashboard.inventory WHERE de.terminal_id = ), de.operation_end_time = (SELECT operation_end FROM dashboard.inventory) WHERE terminal_id IN (SELECT terminal_id FROM dashboard.inventory)

ALTER TABLE dashboard.down_event
ADD CONSTRAINT terminal_id FOREIGN KEY(terminal_id) REFERENCES dashboard.inventory(terminal_id)

ALTER TABLE dashboard.event 
ALTER COLUMN operation_start_time TYPE time without time zone,
ALTER COLUMN operation_end_time TYPE time without time zone;

SELECT * FROM dashboard.inventory

SELECT * FROM dashboard.event order by event_id ASC

SELECT event_description, COUNT(*) FROM dashboard.event GROUP BY event_description

UPDATE dashboard.event de
SET event_description = (array['ATM OUT OF SERVICE', 'ATM BEING SERVICE', 'NETWORK CONNECTION LOST', 'BLACKSCREEN', 'TMD ERROR', 'POSSIBLE COMMUNICATION KEY ERROR ON ATM'])[(random() * 5 + 1)::int] WHERE de.terminal_id IN (SELECT di.terminal_id FROM dashboard.inventory di WHERE di.machine_type = 'ATM');

UPDATE dashboard.event SET (event_start_time, event_end_time, event_start_adj, 

UPDATE dashboard.event 
SET event_status = (array['UP', 'DOWN'])[(random() * 1+1)::int];

INSERT INTO dashboard.event (terminal_id, operation_start_time, operation_end_time)
SELECT terminal_id, operation_start, operation_end FROM dashboard.inventory

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

ALTER TABLE dashboard.down_event
ALTER CONSTRAINT terminal_id FOREIGN KEY(terminal_id) REFERENCES dashboard.inventory(terminal_id);
							
INSERT INTO dashboard.down_event(terminal_id, event_description) VALUES('07007001',(SELECT event_description FROM dashboard.event WHERE terminal_ID = '07007001'))

SELECT * FROM dashboard.down_event WHERE terminal_id = '07007001'

SELECT * FROM dashboard.availability
							
INSERT INTO dashboard.availability(terminal_id, availability_date, availability_time, duration_sec, availability_percentage,in_opt_hrs) VALUES('07007001','2019-10-31','12:00:00',3599.00, 99.97, true) 
							
UPDATE dashboard.down_event SET down_date = '2019-10-31', down_time = '12:00:00', down_duration_sec = 0
							
UPDATE dashboard.event SET event_start_time = '2019-10-31 13:58:07', event_end_time = '2019-10-31 13:58:07', event_start_adj ='2019-10-31 13:58:07', event_end_adj = '2019-10-31 13:58:07', event_duration_mins ='0', planned = 'PLANNED' WHERE terminal_id = '07007001'
							
CREATE TABLE dashboard.down_event
(
    id SERIAL,
    terminal_id character varying(8),
    event_description character varying(90),
    down_date date,
    down_time time without time zone,
    down_duration_sec double precision
)
=====================
SELECT event_description, COUNT(*) AS error_count FROM dashboard.event WHERE terminal_id IN(
	SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM'
) GROUP by event_description ORDER by error_count DESC

UPDATE dashboard.event SET operation_start_time IN (SELECT operation_start FROM dashboard.inventory), operation_end_time IN (SELECT operation_end FROM dashboard.inventory) WHERE terminal_id IN (SELECT terminal_id FROM dashboard.inventory)

ALTER TABLE dashboard.down_event
ADD CONSTRAINT terminal_id FOREIGN KEY(terminal_id) REFERENCES dashboard.inventory(terminal_id)

ALTER TABLE dashboard.event 
ALTER COLUMN operation_start_time TYPE time without time zone,
ALTER COLUMN operation_end_time TYPE time without time zone;

SELECT * FROM dashboard.inventory

SELECT * FROM dashboard.event order by event_id ASC

SELECT event_description, COUNT(*) FROM dashboard.event GROUP BY event_description


UPDATE dashboard.event SET (event_start_time, event_end_time, event_start_adj, 

UPDATE dashboard.event 
SET event_status = (array['UP', 'DOWN'])[(random() * 1+1)::int];

INSERT INTO dashboard.event (terminal_id, operation_start_time, operation_end_time)
SELECT terminal_id, operation_start, operation_end FROM dashboard.inventory

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

ALTER TABLE dashboard.down_event
ALTER CONSTRAINT terminal_id FOREIGN KEY(terminal_id) REFERENCES dashboard.inventory(terminal_id);
							
INSERT INTO dashboard.down_event(terminal_id, event_description) VALUES('07007001',(SELECT event_description FROM dashboard.event WHERE terminal_ID = '07007001'))

SELECT * FROM dashboard.down_event WHERE terminal_id = '07007001'

SELECT * FROM dashboard.availability
							
INSERT INTO dashboard.availability(terminal_id, availability_date, availability_time, duration_sec, availability_percentage,in_opt_hrs) VALUES('07007001','2019-10-31','12:00:00',3599.00, 99.97, true) 
							
UPDATE dashboard.down_event SET down_date = '2019-10-31', down_time = '12:00:00', down_duration_sec = 0
							
UPDATE dashboard.event SET event_start_time = '2019-10-31 13:58:07', event_end_time = '2019-10-31 13:58:07', event_start_adj ='2019-10-31 13:58:07', event_end_adj = '2019-10-31 13:58:07', event_duration_mins ='0', planned = 'PLANNED' WHERE terminal_id = '07007001'

SELECT terminal_id, operation_start, operation_end  FROM dashboard.inventory WHERE terminal_id = '07007001'

CREATE TABLE dashboard.down_event
(
    id SERIAL,
    terminal_id character varying(8),
    event_description character varying(90),
    down_date date,
    down_time time without time zone,
    down_duration_sec double precision
)


SELECT * FROM dashboard.event WHERE terminal_id = '07007001'

UPDATE dashboard.event SET operation_start_time = '10:00:00', operation_end_time = '21:00:00'

--used to set operation_start and operation_end of inventory table to the operation_start_time and operation_end_time of event table
UPDATE dashboard.event e
    SET operation_start_time = i.operation_start,
        operation_end_time = i.operation_end
    FROM dashboard.inventory i
    WHERE e.terminal_id = i.terminal_id;

--used to get the seconds in event_end_adj - event_start_adj
SELECT EXTRACT(EPOCH FROM (SELECT event_end_adj FROM dashboard.event WHERE terminal_id = '07007001')::timestamp - (SELECT event_start_adj FROM dashboard.event WHERE terminal_id = '07007001')::timestamp) AS seconds

--used to get the date
SELECT event_start_adj::TIMESTAMP::DATE FROM dashboard.event WHERE terminal_id = '07007001'

--used to get the time only
SELECT	event_start_adj::TIMESTAMP::TIME FROM dashboard.event WHERE terminal_id = '07007001'

--randomizer to input/update data in the table via randomizing it
UPDATE dashboard.event de
SET event_description = (array['ATM OUT OF SERVICE', 'ATM BEING SERVICE', 'NETWORK CONNECTION LOST', 'BLACKSCREEN', 'TMD ERROR', 'POSSIBLE COMMUNICATION KEY ERROR ON ATM'])[(random() * 5 + 1)::int] WHERE de.terminal_id IN (SELECT di.terminal_id FROM dashboard.inventory di WHERE di.machine_type = 'ATM');

--used to insert random pk from inventory table to event table
INSERT into dashboard.event (terminal_id) 
SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM' ORDER BY random() limit 100

--used to UPDATE down_event table
--note to UPDATE will experiment on INSERT once event_start_adj and event_end_adj on event table is populated
UPDATE dashboard.down_event SET down_date = (SELECT event_start_adj::TIMESTAMP::DATE FROM dashboard.event WHERE terminal_id = '07007001'), down_duration_sec = (SELECT EXTRACT(EPOCH FROM(SELECT event_end_adj FROM dashboard.event WHERE terminal_id='07007001')::timestamp - (SELECT event_start_adj FROM dashboard.event WHERE terminal_id = '07007001')::timestamp)),
down_time = (SELECT	event_start_adj::TIMESTAMP::TIME FROM dashboard.event WHERE terminal_id = '07007001')

--update the event_end_adj in the interval of 1 hour between the event_start_adj and event_end_adj
UPDATE dashboard.event SET event_end_adj = event_start_adj + make_interval(mins => (random() * 59)::int) WHERE event_id = 2066 

--get all the data that is UNPLANNED AND DOWN where the machine_type is 'CAM'
SELECT * FROM dashboard.event WHERE terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM') AND PLANNED = 'UNPLANNED' AND event_status = 'DOWN'

--code to use populate date on event_start_adj
UPDATE dashboard.event SET event_start_adj = '2020-01-01  00:00:00'::timestamp + date_trunc('second',(random() * ('2020-04-16 23:59:59'::timestamp - '2020-01-01 00:00:00'::timestamp)))

--query to update event_star_time and event_end_time = to event_start_adj and event_end_adj
UPDATE dashboard.event SET event_start_time = event_start_adj, event_end_time = event_end_adj WHERE terminal_ID in (SELECT terminal_id FROM dashboard.inventory)