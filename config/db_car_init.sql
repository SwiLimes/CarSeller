create table brand
(
    brand_name varchar(30) not null,
    model_name varchar(30) not null,
    primary key (brand_name, model_name)
);

-- create table engine
-- (
--     id          serial primary key,
--     engine_type varchar(20) not null,
--     capacity    numeric     not null,
--     power       integer     not null,
--     fuel_type   varchar(20) not null
-- );

create table car
(
    vin             varchar(17) primary key,
    brand_name      varchar(30) not null,
    model_name      varchar(30) not null,
    car_year        int         not null,
--     car_type        text        not null,
--     engine_id       integer     not null references engine (id),
--     car_shape       text        not null,
--     drive_unit      text        not null,
--     transmission_id text        not null,
--     equipment       text        not null,
--     consumption     numeric     not null,
--     clearance       numeric     not null,
    foreign key (brand_name, model_name) references brand
);