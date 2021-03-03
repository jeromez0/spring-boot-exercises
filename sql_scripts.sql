drop table if exists Users;

create table Users (
keyID serial primary key,
firstName varchar(50), 
lastName varchar(50), 
phoneNumber numeric(7), 
ssn numeric(9)
);

select * from Users;