CREATE TABLE books
(
    book_id NUMERIC NOT NULL,
    book_name VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL
);
CREATE UNIQUE INDEX BOOKS_PK ON books (book_id);

CREATE TABLE CUSTOMERS
(
    customer_id NUMERIC NOT NULL,
    customer_name VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL
);
CREATE UNIQUE INDEX CUSTOMERS_PK ON customers (customer_id);

CREATE TABLE orders
(
  order_id NUMERIC NOT NULL,
  customer_id NUMERIC NOT NULL,
  book_id NUMERIC NOT NULL,
  order_date DATE NOT NULL
);
CREATE UNIQUE INDEX ORDERS_PK ON orders (order_id);