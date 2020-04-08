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