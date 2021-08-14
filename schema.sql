DROP SCHEMA IF EXISTS Superstore;
CREATE SCHEMA Superstore;
USE Superstore;


CREATE TABLE `Superstore`.customer (
	customer_id int(11) NOT NULL AUTO_INCREMENT,
	first_name varchar(100) NULL,
	last_name varchar(100) NULL,
	email varchar(100) NULL,
	phone int(10) NULL,
	address_id varchar(100) NOT NULL AUTO_INCREMENT,
	CONSTRAINT customer_pk PRIMARY KEY (customer_id),
	CONSTRAINT customer_fk FOREIGN KEY (address_id) REFERENCES `Superstore`.address(address_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1;

CREATE TABLE `Superstore`.`order` (
	order_id int(11) NOT NULL AUTO_INCREMENT,
	customer_id int(11) NOT NULL AUTO_INCREMENT,
	address_id int(11) NOT NULL AUTO_INCREMENT,
	CONSTRAINT order_pk PRIMARY KEY (order_id),
	CONSTRAINT order_fk FOREIGN KEY (customer_id) REFERENCES `Superstore`.customer(customer_id),
	CONSTRAINT order_fk_1 FOREIGN KEY (address_id) REFERENCES `Superstore`.address(address_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1;
CREATE TABLE `Superstore`.product (
	product_id int(11) NOT NULL AUTO_INCREMENT,
	product_name varchar(100) NULL,
	description varchar(100) NULL,
	weight varchar(100) NULL,
	base_cost varchar(100) NULL,
	CONSTRAINT product_pk PRIMARY KEY (product_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1;

CREATE TABLE `Superstore`.product (
	product_id int(11) NOT NULL AUTO_INCREMENT,
	product_name varchar(100) NULL,
	description varchar(100) NULL,
	weight varchar(100) NULL,
	base_cost varchar(100) NULL,
	CONSTRAINT product_pk PRIMARY KEY (product_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1;

CREATE TABLE `Superstore`.order_item (
	order_id int(11) NOT NULL AUTO_INCREMENT,
	product_id int(11) NOT NULL AUTO_INCREMENT,
	quatity FLOAT NULL,
	price varchar(100) NULL,
	CONSTRAINT order_item_fk FOREIGN KEY (order_id) REFERENCES `Superstore`.`order`(order_id),
	CONSTRAINT order_item_fk_1 FOREIGN KEY (product_id) REFERENCES `Superstore`.product(product_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1;

CREATE TABLE `Superstore`.address (
	address_id int(11) NOT NULL AUTO_INCREMENT,
	street varchar(100) NULL,
	city varchar(100) NULL,
	state varchar(100) NULL,
	zip int(7) NULL,
	CONSTRAINT address_pk PRIMARY KEY (address_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;

CREATE TABLE `Superstore`.warehouse (
	warehouse_id int(11) NOT NULL AUTO_INCREMENT,
	name varchar(100) NULL,
	address_id int(11) NOT NULL AUTO_INCREMENT,
	CONSTRAINT warehouse_pk PRIMARY KEY (warehouse_id),
	CONSTRAINT warehouse_fk FOREIGN KEY (address_id) REFERENCES `Superstore`.address(address_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;

CREATE TABLE `Superstore`.product_warehouse (
	product_id int(11) NOT NULL AUTO_INCREMENT,
	warehouse_id int(11) NOT NULL AUTO_INCREMENT,
	CONSTRAINT product_warehouse_fk FOREIGN KEY (product_id) REFERENCES `Superstore`.product(product_id),
	CONSTRAINT product_warehouse_fk_1 FOREIGN KEY (warehouse_id) REFERENCES `Superstore`.warehouse(warehouse_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;
