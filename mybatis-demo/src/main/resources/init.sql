create database mybatis;

create table user(user_id int(20) primary key auto_increment, user_name varchar(50), user_gender varchar(10), birthdate date, address varchar(100));

insert into user(user_name, user_gender, birthdate, address) values('jack', 'male', '1990-10-01', 'shanghai-China');

insert into user(user_name, user_gender, birthdate, address) values('mary', 'female', '1994-11-21', 'tokyo-Japan');

create table orders(order_id int(20) primary key auto_increment, user_id int(20), price double);

insert into orders(user_id, price) values(1, 55.55);

insert into orders(user_id, price) values(1, 33.33);

insert into orders(user_id, price) values(2, 22.22);

create table roles(role_id int(20) primary key auto_increment, role_name varchar(50));

create table user_role(id int(20) primary key auto_increment, user_id int(20), role_id int(20));

insert into roles(role_name) values("admin");

insert into roles(role_name) values("manager");

insert into user_role(user_id, role_id) values(1, 1);

insert into user_role(user_id, role_id) values(1, 2);

insert into user_role(user_id, role_id) values(2, 1);
