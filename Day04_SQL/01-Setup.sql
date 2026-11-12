-- Day 04: SQLite 테스트 데이터 구성
PRAGMA foreign_keys = ON;

DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    age INTEGER,
    status TEXT NOT NULL
);

CREATE TABLE orders (
    order_id INTEGER PRIMARY KEY,
    user_id INTEGER NOT NULL,
    amount INTEGER NOT NULL,
    status TEXT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO users (user_id, name, age, status) VALUES
(101, 'Kim', 25, 'ACTIVE'),
(102, 'Lee', 32, 'ACTIVE'),
(103, 'Park', 28, 'BLOCKED'),
(104, 'Choi', 35, 'ACTIVE'),
(105, 'Jung', 22, 'INACTIVE'),
(106, 'Lim', 30, 'BLOCKED');

INSERT INTO orders (order_id, user_id, amount, status) VALUES
(1001, 101, 15000, 'PAID'),
(1002, 102, 30000, 'PAID'),
(1003, 101, 20000, 'CANCELLED'),
(1004, 104, 45000, 'PAID'),
(1005, 103, 10000, 'PAID'),
(1006, 102, 25000, 'CANCELLED');
