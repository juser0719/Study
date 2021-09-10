CREATE DATABASE  IF NOT EXISTS `happyhouse`;
USE `happyhouse`;
-- drop table member;
create table member(
create table member(
	id varchar(20) not null,
    primary key (id),
    name varchar(20) not null,
    pw int not null,
    address varchar(45),
    phonNum varchar(20),
    dong varchar(30),
    dongcode int
    );