create schema if not exists products;

create table products.category (
	id bigserial primary key,
	name varchar(100) not null
);

INSERT INTO products.category(id, name) VALUES(1, 'Eletrônico');
INSERT INTO products.category(id, name) VALUES(2, 'Móveis');
INSERT INTO products.category(id, name) VALUES(3, 'Brinquedos');
