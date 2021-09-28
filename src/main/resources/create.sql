create table date (date_id  bigserial not null, day int2, month varchar(255), year int4, primary key (date_id))
create table forecast (forecast_id  bigserial not null, description varchar(255), rain_chance float4, temperature int4, date_date_id int8, location_location_id int8, primary key (forecast_id))
create table location (location_id  bigserial not null, city varchar(255), region varchar(255), primary key (location_id))
alter table location add constraint UK_cswwmg4sjv676oudmds2l8y2i unique (city)
alter table forecast add constraint FK1vljb5na8wyd4v0c3dsankfc2 foreign key (date_date_id) references date
alter table forecast add constraint FKh0y5yopbbo5p2w7t0uogpq3d9 foreign key (location_location_id) references location
