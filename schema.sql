CREATE TABLE BOOKS
(
    BOOK_ID NUMERIC NOT NULL,
    BOOK_NAME VARCHAR(100) NOT NULL,
    AUTHOR VARCHAR(100) NOT NULL
);
CREATE UNIQUE INDEX BOOKS_PK ON BOOKS (BOOK_ID);

CREATE TABLE CUSTOMERS
(
    CUSTOMER_ID NUMERIC NOT NULL,
    CUSTOMER_NAME VARCHAR(100) NOT NULL,
    DESCRIPTION VARCHAR(100) NOT NULL
);
CREATE UNIQUE INDEX CUSTOMERS_PK ON CUSTOMERS (CUSTOMER_ID);

CREATE TABLE ORDERS
(
ORDER_ID NUMERIC NOT NULL,
CUSTOMER_ID NUMERIC NOT NULL,
BOOK_ID NUMERIC NOT NULL,
ORDER_DATE DATE NOT NULL
);
CREATE UNIQUE INDEX ORDERS_PK ON ORDERS (ORDER_ID);