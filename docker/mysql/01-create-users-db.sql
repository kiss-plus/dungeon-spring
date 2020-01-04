CREATE DATABASE users;

USE users;

CREATE USER 'elon' IDENTIFIED BY 'tesla-and-spacex';
GRANT ALL ON users.* TO 'elon';