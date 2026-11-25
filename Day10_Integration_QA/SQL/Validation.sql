-- SQL-001
SELECT *
FROM users
WHERE user_id = 1;

-- SQL-002
SELECT user_id, COUNT(*) AS post_count
FROM posts
WHERE user_id = 1
GROUP BY user_id;

-- SQL-003
SELECT p.post_id, p.title, u.name
FROM users AS u
INNER JOIN posts AS p
ON u.user_id = p.user_id
WHERE u.user_id = 1
ORDER BY p.post_id ASC;

-- SQL-004
SELECT ps.post_id, ps.user_id, ps.title
FROM posts_staging AS ps
WHERE NOT EXISTS(
	SELECT 1
	FROM users AS u
	WHERE u.user_id = ps.user_id
);

-- SQL-005
SELECT post_id, title
FROM posts_staging
WHERE (title IS NULL OR TRIM(title) = '');

-- SQL-006
SELECT post_id, CASE 
WHEN u.user_id IS NULL THEN 'INVALID_USER'
WHEN TRIM(ps.title)='' OR ps.title IS NULL THEN 'INVALID_TITLE'
ELSE 'VALID'
END AS validation_result
FROM posts_staging AS ps
LEFT JOIN users AS u
ON ps.user_id = u.user_id
ORDER BY ps.post_id ASC;
