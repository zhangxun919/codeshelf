create database mybatis;

create table user(user_id int(20) primary key auto_increment, user_name varchar(50), user_gender varchar(10), birthdate date, address varchar(100));

insert into user(user_name, user_gender, birthdate, address) values('jack', 'male', '1990-10-01', 'shanghai-China');

insert into user(user_name, user_gender, birthdate, address) values('mary', 'female', '1994-11-21', 'tokyo-Japan');