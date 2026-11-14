PRAGMA foreign_keys = ON;

CREATE TABLE users (
    user_id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    age INTEGER,
    status TEXT NOT NULL,
    phone TEXT
);

CREATE TABLE orders (
    order_id INTEGER PRIMARY KEY,
    user_id INTEGER NOT NULL,
    amount INTEGER,
    status TEXT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO users VALUES
(101, 'Kim', 25, 'ACTIVE', '010-1111-1111'),
(102, 'Lee', 32, 'ACTIVE', NULL),
(103, 'Park', 28, 'BLOCKED', '010-3333-3333'),
(104, 'Choi', 35, 'ACTIVE', NULL),
(105, 'Jung', 22, 'INACTIVE', NULL),
(106, 'Lim', 30, 'ACTIVE', '010-6666-6666');

INSERT INTO orders VALUES
(1001, 101, 15000, 'PAID'),
(1002, 102, 30000, 'PAID'),
(1003, 101, 20000, 'CANCELLED'),
(1004, 104, 45000, 'PAID'),
(1005, 103, 10000, 'PAID'),
(1006, 104, 60000, 'REFUNDED'),
(1007, 102, NULL, 'PAID');
