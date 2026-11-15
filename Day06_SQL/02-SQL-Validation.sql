-- ==========================================
-- 실습 1. 주문 이력이 없는 사용자 조회
-- ==========================================

SELECT user_id, name
FROM users AS u
WHERE NOT EXISTS (
    SELECT 1
    FROM orders AS o
    WHERE u.user_id = o.user_id
)
ORDER BY user_id;


-- ==========================================
-- 실습 2. 사용자별 정상 주문 금액 집계
-- ==========================================

WITH order_totals AS (
    SELECT user_id, SUM(amount) AS total_amount
    FROM orders
    WHERE status = 'PAID'
    GROUP BY user_id
)
SELECT user_id, total_amount
FROM order_totals
WHERE total_amount >= 30000
ORDER BY total_amount DESC;


-- ==========================================
-- 실습 3. 주문 금액과 결제 금액 불일치 검증
-- ==========================================

SELECT o.order_id, o.amount, p.paid_amount
FROM orders AS o
JOIN payments AS p
ON o.order_id = p.order_id
WHERE o.status = 'PAID'
    AND p.status = 'SUCCESS'
    AND o.amount <> p.paid_amount;


-- ==========================================
-- 실습 4. 결제 데이터 누락 검증
-- ==========================================

SELECT o.order_id, o.user_id, o.amount
FROM orders AS o
WHERE o.status = 'PAID'
    AND NOT EXISTS (
        SELECT 1
        FROM payments AS p
        WHERE o.order_id = p.order_id
    )
ORDER BY o.order_id ASC;


-- ==========================================
-- 실습 5. 트랜잭션을 통한 잔액 복구 검증
-- ==========================================

-- 변경 전 잔액 확인
SELECT user_id, balance
FROM users
WHERE user_id = 101;

BEGIN TRANSACTION;

-- 잔액 차감
UPDATE users
SET balance = balance - 10000
WHERE user_id = 101
    AND balance >= 10000;

-- 변경된 행 수 확인
SELECT changes() AS updated_rows;

-- 변경 후 잔액 확인
SELECT user_id, balance
FROM users
WHERE user_id = 101;

-- 변경사항 복구
ROLLBACK;

-- 복구 후 잔액 확인
SELECT user_id, balance
FROM users
WHERE user_id = 101;


-- ==========================================
-- 실습 6. 비정상 결제 주문 탐지
-- ==========================================

SELECT order_id, user_id, amount
FROM orders AS o
WHERE status = 'PAID'
    AND NOT EXISTS (
        SELECT 1
        FROM payments AS p
        WHERE o.order_id = p.order_id
            AND p.status = 'SUCCESS'
            AND o.amount = p.paid_amount
    )
ORDER BY order_id;
