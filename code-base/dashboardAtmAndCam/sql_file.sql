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



ALTER TABLE dashboard.down_event
ALTER CONSTRAINT terminal_id FOREIGN KEY(terminal_id) REFERENCES dashboard.inventory(terminal_id);
							
INSERT INTO dashboard.down_event(terminal_id, event_description) VALUES('07007001',(SELECT event_description FROM dashboard.event WHERE terminal_ID = '07007001'))

SELECT * FROM dashboard.down_event WHERE terminal_id = '07007001'

SELECT * FROM dashboard.availability
							
INSERT INTO dashboard.availability(terminal_id, availability_date, availability_time, duration_sec, availability_percentage,in_opt_hrs) VALUES('07007001','2019-10-31','12:00:00',3599.00, 99.97, true) 
							
UPDATE dashboard.down_event SET down_date = '2019-10-31', down_time = '12:00:00', down_duration_sec = 0
							
UPDATE dashboard.event SET event_start_time = '2019-10-31 13:58:07', event_end_time = '2019-10-31 13:58:07', event_start_adj ='2019-10-31 13:58:07', event_end_adj = '2019-10-31 13:58:07', event_duration_mins ='0', planned = 'PLANNED' WHERE terminal_id = '07007001'

SELECT terminal_id, operation_start, operation_end  FROM dashboard.inventory WHERE terminal_id = '07007001'

SELECT * FROM dashboard.event WHERE terminal_id = '07007001'

UPDATE dashboard.event SET operation_start_time = '10:00:00', operation_end_time = '21:00:00'

INSERT INTO dashboard.availability(terminal_id, availability_date, availability_time)
select td.terminal_id, td.down_date, (hh * interval '1 hour')::time
from (select distinct terminal_id, down_date
      from dashboard.down_event
     ) td cross join
     generate_series(0, 23) gs(hh);

UPDATE dashboard.dummy 
SET duration_sec = 3600 - t.down_duration_sec
FROM (  
    SELECT down_duration_sec, down_date, terminal_id, down_time
    FROM dashboard.down_event 
    WHERE terminal_id IN (SELECT terminal_id FROM dashboard.dummy)
    GROUP BY down_duration_sec, down_date, terminal_id, down_time
) t 
WHERE t.terminal_id = dashboard.dummy.terminal_id
AND dashboard.dummy.availability_date = t.down_date
AND t.down_time BETWEEN dashboard.dummy.availability_time AND dashboard.dummy.availability_time + interval '1 hour'

/***/
SELECT * FROM dashboard.availability WHERE terminal_ID = '30700100' AND availability_date = '2020-02-20'

SELECT terminal_id, COUNT(*) FROM dashboard.down_event GROUP BY terminal_id

INSERT INTO dashboard.availability(terminal_id, availability_date, availability_time)
select td.terminal_id, td.down_date, (hh * interval '1 hour')::time
from (select distinct terminal_id, down_date
      from dashboard.down_event
     ) td cross join
     generate_series(0, 23) gs(hh);
	 

UPDATE dashboard.availability SET duration_sec = 3600, availability_percentage = 100, in_opt_hrs = TRUE

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

SELECT event_description, COUNT(*) as ERROR_COUNT FROM dashboard.event WHERE terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM') GROUP BY event_description ORDER BY ERROR_COUNT DESC LIMIT 5

SELECT terminal_id, ROUND((duration_sec * 100)/3600, 2) AS availability_per FROM dashboard.availability WHERE availability_per < 100


UPDATE dashboard.dummy 
SET availability_percentage = t.availability_per
FROM(
	SELECT terminal_id, ROUND((duration_sec * 100)/3600, 2) AS availability_per FROM dashboard.availability GROUP BY availability_per, terminal_id
)t
WHERE t.terminal_id = dashboard.dummy.terminal_id

SELECT * FROM dashboard.dummy WHERE availability_percentage < 100 AND availability_percentage >= 95

SELECT * FROM dashboard.event WHERE event_status IS NULL OR event_start_time IS NULL OR event_end_time IS NULL OR event_start_adj IS NULL OR event_end_adj IS NULL OR event_description IS NULL or event_duration_mins IS NULL OR operation_start_time IS NULL OR operation_end_time IS NULL or planned IS NULL

SELECT * FROM dashboard.down_event
CREATE TABLE dashboard.down_event
(
    id SERIAL,
    terminal_id character varying(8),
    event_description character varying(90),
    down_date date,
    down_time time without time zone,
    down_duration_sec double precision
)

INSERT into dashboard.event (terminal_id) 
SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM' ORDER BY random() limit 100

UPDATE dashboard.event SET event_start_adj = '2020-01-01  00:00:00'::timestamp + date_trunc('second',(random() * ('2020-04-16 23:59:59'::timestamp - '2020-01-01 00:00:00'::timestamp)))

UPDATE dashboard.event SET event_end_adj = event_start_adj + make_interval(mins => (random() * 59)::int)

UPDATE dashboard.event SET event_start_time = event_start_adj, event_end_time = event_end_adj WHERE terminal_ID in (SELECT terminal_id FROM dashboard.inventory)

UPDATE dashboard.event de
SET planned = (array['UNPLANNED', 'PLANNED'])[(random() * 1 + 1)::int] WHERE de.terminal_id IN (SELECT di.terminal_id FROM dashboard.inventory di WHERE di.machine_type = 'CAM');

UPDATE dashboard.event SET event_duration_mins = (DATE_PART('day', event_end_adj::timestamp - event_start_adj::timestamp) * 24 + 
               DATE_PART('hour', event_end_adj::timestamp - event_start_adj::timestamp)) * 60 +
               DATE_PART('minute', event_end_adj::timestamp - event_start_adj::timestamp);
			   
UPDATE dashboard.event e
    SET operation_start_time = i.operation_start,
        operation_end_time = i.operation_end
    FROM dashboard.inventory i
    WHERE e.terminal_id = i.terminal_id;
	
INSERT INTO dashboard.down_event(terminal_id, event_description, down_date, down_time, down_duration_sec)
SELECT terminal_id, event_description,
       event_start_adj::TIMESTAMP::DATE AS date, 
       event_start_adj::TIMESTAMP::TIME AS time,
       (EXTRACT(EPOCH FROM event_end_adj::TIMESTAMP) -
        EXTRACT(EPOCH FROM event_start_adj::TIMESTAMP)
       ) AS seconds
FROM dashboard.event
WHERE event_status = 'DOWN' AND planned = 'UNPLANNED'

INSERT INTO dashboard.availability(terminal_id, availability_date, availability_time)
select td.terminal_id, td.down_date, (hh * interval '1 hour')::time
from (select distinct terminal_id, down_date
      from dashboard.down_event
     ) td cross join
     generate_series(0, 23) gs(hh);

SELECT * FROM dashboard.availability WHERE terminal_id = '38560100'
SELECT * FROM dashboard.availability WHERE duration_sec = 3600 and availability_percentage < 100

SELECT terminal_id, availability_date, availability_time, availability_percentage FROM dashboard.availability WHERE availability_percentage >= 95 AND availability_date = '2020-04-16' ORDER BY availability_percentage DESC

SELECT availability_date FROM dashboard.availability ORDER BY availability_date DESC

UPDATE dashboard.dummy SET duration_sec = 3600, availability_percentage = 100, in_opt_hrs = TRUE

SELECT terminal_id, COUNT(*) FROM dashboard.down_event GROUP BY terminal_id

SELECT * FROM dashboard.down_event WHERE terminal_id = '30620100' and down_date = '2020-01-29'
SELECT * FROM dashboard.down_event WHERE terminal_id = '01301308' and down_date = '2020-01-10'

UPDATE dashboard.dummy SET availability_percentage = 100

UPDATE dashboard.availability dd
SET availability_percentage = ROUND((((3600 - t.down_duration_sec) /3600) * 100)::numeric, 2)
FROM(
	SELECT terminal_id, down_duration_sec, down_date FROM dashboard.down_event WHERE terminal_id IN (SELECT terminal_id FROM dashboard.dummy) GROUP BY terminal_id, down_duration_sec, down_date
)t
WHERE dd.duration_sec < 3600
AND dd.availability_date = t.down_date
AND dd.terminal_id = t.terminal_id


-- returns 35
SELECT terminal_id, ROUND((((SELECT down_duration_sec FROM dashboard.down_event WHERE terminal_id = '07667662') * 100)/3600)::numeric, 2) AS availability_per FROM dashboard.availability WHERE terminal_id = '07667662' GROUP BY availability_per,terminal_id 

-- returns 35 (formula mo)
SELECT terminal_id, ROUND((((SELECT down_duration_sec FROM dashboard.down_event WHERE terminal_id = '07667662') * 100)/3600)::numeric, 2) AS availability_per FROM dashboard.availability WHERE terminal_id = '07667662' GROUP BY availability_per,terminal_id 
(1260 * 100) / 3600 = 35

--returns 65(formula nila sam)
SELECT terminal_id, ROUND((((3600 - (SELECT down_duration_sec FROM dashboard.down_event WHERE terminal_id = '07667662'))/3600) * 100)::numeric, 2) AS availability_per FROM dashboard.availability WHERE terminal_id = '07667662' GROUP BY availability_per,terminal_id 

((3600 - 1260) / 3600) * 100 = 65

SELECT * FROM dashboard.availability WHERE availability_percentage < 100

CREATE TABLE dashboard.dummy
(
    terminal_id character varying(8),
    availability_date date,
    availability_time time without time zone,
    duration_sec numeric(8,2),
    availability_percentage numeric(8,2),
    in_opt_hrs boolean,
    CONSTRAINT dummy_pkey PRIMARY KEY (terminal_id, availability_date, availability_time)
)

INSERT INTO dashboard.dummy(terminal_id, availability_date, availability_time)
select td.terminal_id, td.down_date, (hh * interval '1 hour')::time
from (select distinct terminal_id, down_date
      from dashboard.down_event
     ) td cross join
     generate_series(0, 23) gs(hh);
	 
UPDATE dashboard.availability SET duration_sec = 3600, availability_percentage = 100, in_opt_hrs = TRUE

SELECT * FROM dashboard.availability WHERE duration_sec < 3600

UPDATE dashboard.availability 
SET duration_sec = 3600 - t.down_duration_sec
FROM (  
    SELECT down_duration_sec, down_date, terminal_id, down_time
    FROM dashboard.down_event 
    WHERE terminal_id IN (SELECT terminal_id FROM dashboard.availability)
    GROUP BY down_duration_sec, down_date, terminal_id, down_time
) t 
WHERE t.terminal_id = dashboard.availability.terminal_id
AND dashboard.availability.availability_date = t.down_date
AND t.down_time BETWEEN dashboard.availability.availability_time AND dashboard.availability.availability_time + interval '1 hour'

SELECT terminal_id, availability_percentage FROM dashboard.availability WHERE terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM') AND availability_date = '2020-04-16' AND availability_percentage >= 95

SELECT terminal_id, event_description FROM dashboard.down_event WHERE down_date = '2020-04-16' AND terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')

SELECT terminal_id, event_description FROM dashboard.down_event WHERE down_date = '2020-04-16'

SELECT * FROM dashboard.event WHERE terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM') AND event_status = 'DOWN' AND planned = 'UNPLANNED' AND event_start_adj::TIMESTAMP::DATE = '2020-04-16'

SELECT event_description, COUNT(*) AS error_count 
					 FROM dashboard.down_event 
					 WHERE down_date = '2020-04-05'
					 AND terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')
					 GROUP BY event_description ORDER BY error_count DESC

SELECT event_description, COUNT(*) AS error_count 
					 FROM dashboard.down_event 
					 WHERE down_date BETWEEN '2020-04-05' AND '2020-04-15'
					 AND terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')
					 GROUP BY event_description ORDER BY error_count DESC

                     SELECT event_description, COUNT(*) AS error_count 
					 FROM dashboard.down_event 
					 WHERE down_date = '2020-04-05'
					 AND terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')
					 GROUP BY event_description ORDER BY error_count DESC

SELECT event_description, COUNT(*) AS error_count 
					 FROM dashboard.down_event 
					 WHERE down_date BETWEEN '2020-04-05' AND '2020-04-15'
					 AND terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')
					 GROUP BY event_description ORDER BY error_count DESC
					 
SELECT terminal_id, COUNT(*) AS terminal_count
FROM dashboard.availability
WHERE availability_date BETWEEN '2020-04-05' AND '2020-04-15'
AND availability_percentage >= 95
AND terminal_id IN (
	SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM'
)
GROUP BY terminal_id
ORDER BY availability_percentage DESC

SELECT * FROM dashboard.availability
WHERE terminal_id = '30290100'
AND availability_date BETWEEN '2020-04-05' AND '2020-04-15'
AND availability_percentage >= 95
ORDER BY availability_time ASC

SELECT DISTINCT da.terminal_id, da.availability_date, da.availability_percentage
FROM dashboard.availability da
INNER JOIN dashboard.down_event de ON de.terminal_id = da.terminal_id
WHERE da.availability_percentage >= 95
AND da.availability_date BETWEEN '2020-04-05' AND '2020-04-06'	
AND da.terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')


SELECT DISTINCT terminal_id, availability_time, availability_date, availability_percentage
FROM dashboard.availability

SELECT DISTINCT da.terminal_id, da.availability_date, da.availability_percentage
FROM dashboard.availability da
INNER JOIN dashboard.down_event de ON de.terminal_id = da.terminal_id
WHERE da.availability_percentage >= 95 AND da.availability_percentage < 100
AND da.availability_date BETWEEN '2020-03-10' AND '2020-04-15'	
AND da.terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')

SELECT DISTINCT da.terminal_id, da.availability_date, da.availability_percentage
FROM dashboard.availability da
INNER JOIN dashboard.down_event de ON de.terminal_id = da.terminal_id
WHERE da.availability_percentage >= 95 
AND da.availability_date = '2020-03-14'
AND da.terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')

SELECT event_description, COUNT(*) AS error_count 
					 FROM dashboard.down_event 
					 WHERE down_date = '2020-04-16'
					 AND terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')
					 GROUP BY event_description ORDER BY error_count DESC

--COMPARING 2 TABLE RESULT
SELECT
    ROUND(AVG(availability_percentage)
       FILTER (WHERE availability_date BETWEEN '2020-03-01' AND '2020-04-01') , 2) AS avg_march,
    ROUND(AVG(availability_percentage)
       FILTER (WHERE availability_date BETWEEN '2020-04-01' AND '2020-05-01'), 2) AS avg_april
FROM dashboard.availability
WHERE availability_date BETWEEN '2020-03-01' AND '2020-05-01';

--gets the total availability time of the machine for each hour
SELECT da.availability_time, (ROUND(AVG(da.availability_percentage),2)) AS total_hour_percentage
FROM dashboard.availability da
INNER JOIN dashboard.inventory di ON da.terminal_id = di.terminal_id
WHERE di.machine_type = 'CAM'
AND da.availability_date BETWEEN '2020-03-01' AND '2020-04-01'
GROUP BY da.availability_time 
ORDER BY da.availability_time ASC

-- top 5 low availability percentage CAM
SELECT terminal_id, ROUND(AVG(availability_percentage),2) AS availability_each_terminal
FROM dashboard.availability
WHERE availability_date = '2020-04-05'
AND terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')
GROUP BY terminal_id
ORDER BY availability_each_terminal ASC LIMIT 5

--uses the result and creates a dummy row (CAN BE USED IN COMPARING MONTHS)
SELECT
   unnest(array['avg_march', 'avg_april']) AS months,
   unnest(array[avg_march, avg_april]) AS values
FROM(
	SELECT
		ROUND(AVG(availability_percentage)
		   FILTER (WHERE availability_date BETWEEN '2020-03-01' AND '2020-04-01') , 2) AS avg_march,
		ROUND(AVG(availability_percentage)
		   FILTER (WHERE availability_date BETWEEN '2020-04-01' AND '2020-05-01'), 2) AS avg_april
	FROM dashboard.availability
WHERE availability_date BETWEEN '2020-03-01' AND '2020-05-01'
	)t

    SELECT event_description,COUNT(*) FROM dashboard.down_event
WHERE down_date = '2020-04-06'
group by event_description
ORDER BY count DESC

SELECT event_description,COUNT(*) FROM dashboard.down_event
WHERE down_date BETWEEN '2020-04-05' AND '2020-04-15'
group by event_description
ORDER BY count DESC

--DAILY
--gets the availability per date
SELECT availability_date, ROUND(AVG(availability_percentage),2)
FROM dashboard.availability
WHERE terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')
AND availability_date BETWEEN '2020-04-05' AND '2020-04-15'
GROUP BY availability_date

--gets the event count per date
SELECT down_date, event_description, COUNT(*)
FROM dashboard.down_event
WHERE terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')
AND down_date BETWEEN '2020-04-05' AND '2020-04-15'
GROUP BY event_description, down_date
ORDER BY down_date DESC

--getst the total count
SELECT event_description, COUNT(*)
FROM dashboard.down_event
WHERE terminal_id IN (SELECT terminal_id FROM dashboard.inventory WHERE machine_type = 'CAM')
AND down_date BETWEEN '2020-04-05' AND '2020-04-15'
GROUP BY event_description
ORDER BY count DESC

--uses the result and creates a dummy row (CAN BE USED IN COMPARING MONTHS) COMPARING AVAILABILITY
SELECT
   unnest(array['last_Month', 'curr_Month', 'next_Month']) AS months,
   unnest(array[lastMonth, currMonth, nextMonth]) AS values
FROM(
	SELECT
		ROUND(AVG(availability_percentage)
		   FILTER (WHERE availability_date BETWEEN '2020-02-01' AND '2020-02-29') , 2) AS lastMonth,
		ROUND(AVG(availability_percentage)
		   FILTER (WHERE availability_date BETWEEN '2020-03-01' AND '2020-03-31'), 2) AS currMonth,
		ROUND(AVG(availability_percentage)
			 FILTER(WHERE availability_date BETWEEN '2020-04-01' AND '2020-04-30'),2) AS nextMonth
	FROM dashboard.availability
	)t

    