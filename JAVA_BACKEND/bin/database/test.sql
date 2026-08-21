
create table user (
    uno int auto_increment ,
    constraint primary key (uno) ,
    uid varchar(15) not null unique ,
    upwd varchar(15) not null,
    uphone varchar(20) not null unique,
    uname varchar(10) not null ,
    ugrade varchar(10) not null,
    ustudentid varchar(20) not null unique,
); 