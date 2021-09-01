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


--function for updating the product_quantity with the quantity of the product_stock table
CREATE or replace function update_product_quantity_func()
returns trigger 
LANGUAGE plpgsql
AS $$
begin
UPDATE ims.product p
set product_quantity = case 
	when transaction_type = 'IN' then product_quantity + quantity
	when transaction_type = 'OUT' then product_quantity - quantity
	end
FROM 
    ims.product_stock s
WHERE 
    p.product_id = s.product_id;
 return null;
end;
$$;

--trigger made to run after a row is insertee onto product_stock to take that rows quantity
--and update product with the update_product_quantity_func
CREATE TRIGGER check_insert
    after INSERT ON ims.product_stock 
    for each row
    EXECUTE function update_product_quantity_func();