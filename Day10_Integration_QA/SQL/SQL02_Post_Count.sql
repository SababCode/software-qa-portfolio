SELECT user_id, COUNT(*) AS post_count
FROM posts
WHERE user_id = 1
GROUP BY user_id;