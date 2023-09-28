CREATE TABLE users
(
    username    VARCHAR(50) primary key ,
    password    VARCHAR(50) not null ,
    enable      boolean not null


);

CREATE TABLE authorities
(
    id serial primary key ,
    username varchar(50) not null ,
    authority varchar(50) not null ,
    CONSTRAINT fk_username FOREIGN KEY (username) references users (username) on delete cascade
);