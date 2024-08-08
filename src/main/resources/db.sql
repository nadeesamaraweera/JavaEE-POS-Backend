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
);

create table `order`
(
                     id          varchar(60) NOT NULL PRIMARY KEY ,
                     date        varchar(60) NOT NULL ,
                     customer_id varchar(60) NOT NULL ,
                     total       double      NOT NULL ,
                     discount    varchar(20) NOT NULL ,
                     sub_total   double      NOT NULL ,
                     cash        double      NOT NULL ,
                     balance     double      NOT NULL ,
                     CONSTRAINT order_customer_cust_id_fk FOREIGN KEY (customer_id)REFERENCES customer (cust_id)
);