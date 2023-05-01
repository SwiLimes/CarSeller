create table brand
(
    brand_name varchar(30) not null,
    model_name varchar(30) not null,
    primary key (brand_name, model_name)
);

create table engine
(
    id        serial primary key,
    type      varchar(20) not null,
    capacity  numeric     not null,
    power     integer     not null,
    fuel_type varchar(10) not null
);

create table car
(
    vin             char(17) primary key,
    brand_name      varchar(30) not null,
    model_name      varchar(30) not null,
    car_year        integer     not null,
    car_type        text        not null,
    equipment       text        not null,
    engine_id       integer     not null references engine (id),
    car_body        text        not null,
    drive_unit      text        not null,
    transmission_id text        not null,
    consumption     numeric     not null,
    clearance       numeric     not null,
    foreign key (brand_name, model_name) references brand
);