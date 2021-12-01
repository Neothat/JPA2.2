CREATE TABLE products
(
    id    bigserial primary key,
    title varchar(255),
    cost  integer
);
INSERT INTO products (title, cost)
VALUES ('Bread', 26),
       ('Milk', 58),
       ('Apples', 99),
       ('Beans', 115),
       ('Eggs', 90);

CREATE TABLE customers
(
    id              bigserial primary key,
    customers_names varchar(255)
);
INSERT INTO customers (customers_names)
VALUES ('Accidental genius'),
       ('Big Mac'),
       ('Coffee zombie'),
       ('Dreamy devil ');

CREATE TABLE orders
(
    id          bigserial primary key,
    customer_id integer references customers (id),
    product_id  integer references products (id)
);
INSERT INTO orders (customer_id, product_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 1),
       (2, 2),
       (3, 4),
       (3, 5),
       (4, 1),
       (4, 5)