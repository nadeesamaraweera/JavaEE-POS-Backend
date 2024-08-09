DROP DATABASE IF EXISTS thogakade;

CREATE DATABASE IF NOT EXISTS  thogakade;

SHOW DATABASES;

USE thogakade;



create table customer(
                         cust_id VARCHAR(50) PRIMARY KEY,
                         cust_name VARCHAR(50) NOT NULL,
                         cust_address VARCHAR(50) NOT NULL,
                         cust_salary DOUBLE NOT NULL
);

create table item(
                      item_id VARCHAR(20) NOT NULL PRIMARY KEY ,
                      item_name  VARCHAR(50) NOT NULL ,
                      item_qty   INT         NOT NULL ,
                      item_price DOUBLE     NOT NULL
);

create table `order`(
                     id          VARCHAR(60) NOT NULL PRIMARY KEY ,
                     date        VARCHAR(60) NOT NULL ,
                     cust_id     VARCHAR(50) NOT NULL ,
                     total       DOUBLE      NOT NULL ,
                     discount    VARCHAR(20) NOT NULL ,
                     sub_total   DOUBLE     NOT NULL ,
                     cash        DOUBLE      NOT NULL ,
                     balance     DOUBLE     NOT NULL ,
                     CONSTRAINT order_customer_cust_id_fk FOREIGN KEY (cust_id)REFERENCES customer (cust_id)
);

create table order_detail(
                     order_id VARCHAR(60) NULL ,
                     item_id  VARCHAR(60) NULL ,
                     qty      INT       NOT NULL ,
   CONSTRAINT order_detail_item_item_id_fk FOREIGN KEY (item_id) REFERENCES item (item_id),
    CONSTRAINT order_detail_order_id_fk FOREIGN KEY (order_id) REFERENCES `order` (id)
);