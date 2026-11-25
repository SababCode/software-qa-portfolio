DROP TABLE IF EXISTS posts_staging;
DROP TABLE IF EXISTS api_post_responses;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL
);

CREATE TABLE posts (
    post_id INTEGER PRIMARY KEY,
    user_id INTEGER NOT NULL,
    title TEXT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE api_post_responses (
    post_id INTEGER PRIMARY KEY,
    user_id INTEGER NOT NULL,
    title TEXT NOT NULL,
    body TEXT NOT NULL
);

CREATE TABLE posts_staging (
    post_id INTEGER PRIMARY KEY,
    user_id INTEGER,
    title TEXT
);

INSERT INTO users VALUES
(1, 'Leanne Graham', 'Sincere@april.biz');

INSERT INTO posts VALUES
(1, 1, 'sunt aut facere repellat provident occaecati excepturi optio reprehenderit'),
(2, 1, 'qui est esse'),
(3, 1, 'ea molestias quasi exercitationem repellat qui ipsa sit aut'),
(4, 1, 'eum et est occaecati'),
(5, 1, 'nesciunt quas odio'),
(6, 1, 'dolorem eum magni eos aperiam quia'),
(7, 1, 'magnam facilis autem'),
(8, 1, 'dolorem dolore est ipsam'),
(9, 1, 'nesciunt iure omnis dolorem tempora et accusantium'),
(10, 1, 'optio molestias id quia eum');

INSERT INTO api_post_responses VALUES
(101, 1, 'Day10 QA Test', 'Postman API validation practice');

INSERT INTO posts_staging VALUES
(201, 1, 'QA validation test'),
(202, 999, 'Unknown user post'),
(203, 1, '   '),
(204, 1, NULL);