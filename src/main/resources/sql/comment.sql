create table comment (
     no int auto_increment primary key,
     bno int not null,
     user_id varchar(20) not null,
     ccontent text not null,
     write_date timestamp default now(),
     foreign key(bno) references qna_board(bno),
     foreign key(user_id) references member(user_id)
);