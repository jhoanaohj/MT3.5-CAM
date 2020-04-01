CREATE TABLE dashboard.inventory
(
    machine_name character varying(256),
    terminal_id character varying(8),
    rc_code character varying(3),
    handled_by character varying(10),
    model character varying(50),
    os character varying(50),
    vendor character varying(50)L,
    serial_number character varying(30),
    area character varying(20),
    onsite character varying(25),
    acquisition_date date,
    operational_date date,
    delivery_date date,
    installation_date date,
    address character varying(300),
    status character varying(50),
    ma_service_provider character varying(50),
    service_provider character varying(10),
    operation_start time without time zone,
    operation_end time without time zone,
    machine_type character varying(5),
    create_date timestamp without time zone,
    update_date timestamp without time zone,
    region_iso_code character varying(6),
    province_iso_code character varying(6),
    rating character varying(3),
    stand_alone_branch boolean,
    CONSTRAINT inventory_pkey PRIMARY KEY (terminal_id)
)


UPDATE dashboard.inventory
SET operation_start = ,
operation_end = ,
update_date = NOW()
WHERE terminal_id = 