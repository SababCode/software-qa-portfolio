SELECT p.post_id, p.title, u.name
FROM users AS u
INNER JOIN posts AS p
ON u.user_id = p.user_id
WHERE u.user_id = 1
ORDER BY p.post_id ASC;
