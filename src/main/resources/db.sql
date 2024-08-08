DROP DATABASE IF EXISTS thogakade;

CREATE DATABASE IF NOT EXISTS  thogakade;

SHOW DATABASES;

USE thogakade;



create table customer(
                         id VARCHAR(15) PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         address VARCHAR(255) NOT NULL,
                         salary DOUBLE NOT NULL
);