SELECT post_id, CASE 
WHEN u.user_id IS NULL THEN 'INVALID_USER'
WHEN TRIM(ps.title)='' OR ps.title IS NULL THEN 'INVALID_TITLE'
ELSE 'VALID'
END AS validation_result
FROM posts_staging AS ps
LEFT JOIN users AS u
ON ps.user_id = u.user_id
ORDER BY ps.post_id ASC;