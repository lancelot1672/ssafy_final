create table houselike(
                          no int auto_increment primary key,
                          user_id varchar(20),
                          housecode bigint,
                          foreign key(user_id) references member(user_id),
                          foreign key(housecode) references housedeal(no)
);

insert into houselike (user_id, housecode) values ('ssafy',112002102000013);

