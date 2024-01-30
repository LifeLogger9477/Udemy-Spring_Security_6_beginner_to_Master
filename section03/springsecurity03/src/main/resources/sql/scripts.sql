create database eazybank;

use eazybank;

create table users(
                      id int not null auto_increment,
                      username varchar(45) not null,
                      password varchar(45) not null,
                      enabled int not null,
                      primary key (id)
);

create table authorities (
                             id int not null auto_increment,
                             username varchar(45) not null,
                             autority varchar(45) not null,
                             primary key (id)
);

INSERT INTO eazybank.users
(id, username, password, enabled)
VALUES(1, 'happy', '12345', 0);

INSERT INTO eazybank.authorities
(id, username, autority)
VALUES(1, 'happy', 'write');