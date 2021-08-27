DROP SCHEMA IF EXISTS ims CASCADE;

CREATE SCHEMA ims AUTHORIZATION postgres;

CREATE TABLE ims.product(
	product_id serial not null primary KEY,
	title varchar(40),
	category varchar(20),
	man varchar(40),
	min_limit int
);


CREATE TABLE ims.product_stock (
	stock_id serial not null,
	product_id int,
	transaction_date date NOT NULL,
	vendor varchar(40) NOT NULL,
	batch_code varchar(10),
	invoice_num varchar(10),
	quantity int not null,
	transaction_type int NOT null,
	primary key (product_id),
	constraint fk_product
		foreign key (product_id) 
			references ims.product(product_id)
);

INSERT INTO ims.product (title, category, man, min_limit) VALUES ('Maple Chest Drawer', 'furniture', 'Furn Builder Co.', 10);
INSERT INTO ims.product_stock (product_id, transaction_date, vendor, batch_code, invoice_num, quantity, transaction_type) VALUES (1, '2021/08/25', 'Goodwill LLC', 'ABC122', 'JAN23002', 3, 0);
