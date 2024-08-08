DROP DATABASE IF EXISTS thogakade;

CREATE DATABASE IF NOT EXISTS  thogakade;

SHOW DATABASES;

USE thogakade;



create table customer(
                         cust_id VARCHAR(15) PRIMARY KEY,
                         cust_name VARCHAR(255) NOT NULL,
                         cust_address VARCHAR(255) NOT NULL,
                         cust_salary DOUBLE NOT NULL
);

create table item(
                      item_id varchar(20) NOT NULL PRIMARY KEY ,
                      item_name  varchar(50) NOT NULL ,
                      item_qty   int         NOT NULL ,
                      item_price double      NOT NULL
)