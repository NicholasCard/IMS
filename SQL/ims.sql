DROP SCHEMA IF EXISTS ims CASCADE;

CREATE SCHEMA ims AUTHORIZATION postgres;

CREATE TABLE ims.product (
	product_id serial NOT NULL,
	title varchar(40) NULL,
	category varchar(20) NULL,
	man varchar(40) NULL,
	min_limit int4 NULL,
	product_quantity int4 NOT NULL,
	CONSTRAINT product_pkey PRIMARY KEY (product_id)
);


CREATE TABLE ims.product_stock (
	stock_id serial NOT NULL,
	product_id int4 NOT NULL,
	transaction_date date NOT NULL,
	vendor varchar(40) NOT NULL,
	batch_code varchar(10) NULL,
	invoice_num varchar(10) NULL,
	quantity int4 NOT NULL,
	transaction_type varchar(3) NOT NULL,
	CONSTRAINT product_stock_pkey PRIMARY KEY (product_id)
);

ALTER TABLE ims.product_stock ADD CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES ims.product(product_id);

INSERT INTO ims.product
(product_id, title, category, man, min_limit, quantity)
VALUES(1, 'Maple Chest Drawer', 'furniture', 'Furn Builder Co.', 10, 20);
INSERT INTO ims.product
(product_id, title, category, man, min_limit, quantity)
VALUES(2, 'Oak Desk', 'furniture', 'Oakers', 8, 22);
INSERT INTO ims.product
(product_id, title, category, man, min_limit, quantity)
VALUES(3, 'Black HD TV', 'electronics', 'Axer', 5, 14);
INSERT INTO ims.product
(product_id, title, category, man, min_limit, quantity)
VALUES(4, 'Standing Lamp', 'furniture', 'Lamp Factory', 10, 26);

INSERT INTO ims.product_stock
(stock_id, product_id, transaction_date, vendor, batch_code, invoice_num, quantity, transaction_type)
VALUES(1, 1, '2021-08-25', 'Goodwill LLC', 'ABC122', 'JAN23002', 3, 'IN');

