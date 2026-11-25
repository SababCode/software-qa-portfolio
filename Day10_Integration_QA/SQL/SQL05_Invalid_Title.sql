SELECT post_id, title
FROM posts_staging
WHERE (title IS NULL OR TRIM(title) = '');