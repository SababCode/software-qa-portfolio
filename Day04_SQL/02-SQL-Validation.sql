-- Day 04: SQL 기반 데이터 조회 및 API/DB 정합성 검증
-- 실행 환경: SQLite / DB Browser for SQLite
-- 쿼리는 위에서 아래로 개별 실행하여 결과를 비교합니다.

-- 1. ACTIVE 상태이며 30세 이상 사용자 조회
-- 기대 결과: (104, Choi, 35), (102, Lee, 32)
SELECT user_id, name, age
FROM users
WHERE status = 'ACTIVE' AND age >= 30
ORDER BY age DESC;

-- 2. 주문 상태별 건수 집계
-- 기대 결과: (PAID, 4), (CANCELLED, 2)
SELECT status, COUNT(*) AS order_count
FROM orders
GROUP BY status
ORDER BY order_count DESC;

-- 3. PAID 주문의 사용자별 결제 총액 중 20,000 이상 조회
-- 기대 결과: (Choi, 45000), (Lee, 30000)
SELECT u.name, SUM(o.amount) AS total_amount
FROM users AS u
INNER JOIN orders AS o
    ON u.user_id = o.user_id
WHERE o.status = 'PAID'
GROUP BY u.user_id, u.name
HAVING SUM(o.amount) >= 20000
ORDER BY total_amount DESC;

-- 4. API 응답과 DB 상태 불일치 검증(가상 API 사례)
-- 가정: GET /users/103 응답 status = 'ACTIVE'
-- 기대 DB 값: (103, Park, BLOCKED)
-- 판정: 최신 상태가 일치해야 하는 명세일 경우 FAIL
SELECT user_id, name, status
FROM users
WHERE user_id = 103;

-- 비교 검증: 다른 사용자의 상태도 확인
-- 기대 결과: (101, Kim, ACTIVE), (103, Park, BLOCKED), (106, Lim, BLOCKED)
SELECT user_id, name, status
FROM users
WHERE user_id IN (101, 103, 106)
ORDER BY user_id;
