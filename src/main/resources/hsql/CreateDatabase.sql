DROP TABLE Items IF EXISTS;
CREATE TABLE Items (
id      INTEGER PRIMARY KEY,
code    VARCHAR(30),
category    VARCHAR(2),
description     VARCHAR(50),
price   DECIMAL ( 6, 2 )
);

DROP TABLE Users IF EXISTS;
CREATE TABLE Users (
    id      INTEGER PRIMARY KEY,
    name    VARCHAR(30),
    cartFk INTEGER
);

DROP TABLE Carts IF EXISTS;
CREATE TABLE Carts (
    id      INTEGER PRIMARY KEY,
    info    VARCHAR(30)
);

DROP TABLE CartItems IF EXISTS;
CREATE TABLE CartItems (
    id      IDENTITY PRIMARY KEY,
    cartFk INTEGER,
    itemFk  INTEGER
);

DROP TABLE Orders IF EXISTS;
CREATE TABLE Orders (
id      INTEGER PRIMARY KEY,
total   DECIMAL ( 4, 2 ),
status  VARCHAR(30),
userFk  INTEGER
);

DROP TABLE OrderItems IF EXISTS;
CREATE TABLE OrderItems (
    id      INTEGER PRIMARY KEY,
    orderFk INTEGER,
    itemFk  INTEGER
);
