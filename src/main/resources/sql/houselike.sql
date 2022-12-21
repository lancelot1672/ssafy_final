create table houselike(
                          no int auto_increment primary key,
                          user_id varchar(20),
                          housecode bigint,
                          foreign key(user_id) references member(user_id),
                          foreign key(housecode) references housedeal(no)
);

insert into houselike (user_id, housecode) values ('ssafy',112002102000013);

select *
from houselike as hl join houseView as hv on hl.housecode = hv.no where user_id = 'ssafy';

create view houseView as select hd.no, hi.apartmentName, hd.floor, hi.dong as 'dongName', hd.dealYear, hd.dealMonth, hd.area, hd.dealamount, hi.lat, hi.lng, hd.aptcode
                         from housedeal hd join houseinfo hi
                                                on hd.aptcode = hi.aptcode;

select * from houseView