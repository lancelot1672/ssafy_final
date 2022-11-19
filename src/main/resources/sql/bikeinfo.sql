

drop table bikeinfo;

create table bikeinfo (
 rent_id int primary key auto_increment,
 rent_name varchar(100) not null,
 address1 varchar(100),
 address2 varchar(100),
 lat varchar(100) not null,
 lng varchar(100) not null
 );

 SELECT * FROM ssafy_home.bikeinfo;