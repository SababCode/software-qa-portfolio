# Day 06 - SQL 종합 데이터 정합성 검증

## 학습 내용

- `NOT EXISTS`를 활용한 연관 데이터 누락 검증
- `CTE (WITH)`, `SUM()`, `GROUP BY`를 활용한 데이터 집계
- `JOIN`을 활용한 주문 및 결제 데이터 불일치 검증
- `BEGIN TRANSACTION`, `ROLLBACK`을 활용한 데이터 변경 및 복구
- `UPDATE` 조건을 활용한 데이터 변경 범위 제한

## 실습 환경

- SQLite / DB Browser for SQLite
- 테스트 테이블: `users`, `orders`, `payments`

## 파일 구성

| **파일** | **내용** |
| --- | --- |
| `01-Setup.sql` | 테스트 테이블 생성 및 샘플 데이터 입력 |
| `02-SQL-Validation.sql` | SQL 종합 데이터 정합성 검증 실습 6문제 |

## QA 검증 관점

- 주문 상태 및 결제 금액의 정합성 확인
- 결제 기록 누락과 비정상 데이터 탐지
- 트랜잭션 실행 전후 데이터 변경 및 복구 여부 검증
