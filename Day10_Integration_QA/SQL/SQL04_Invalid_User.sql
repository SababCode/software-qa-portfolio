SELECT ps.post_id, ps.user_id, ps.title
FROM posts_staging AS ps
WHERE NOT EXISTS(
	SELECT 1
	FROM users AS u
	WHERE u.user_id = ps.user_id
);