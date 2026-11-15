# Day 05 - SQL 심화 데이터 검증

## 학습 내용
- `LEFT JOIN`, `IS NULL`을 활용한 연관 데이터 누락 확인
- 서브쿼리와 `AVG()`를 활용한 조건별 데이터 조회
- `CASE WHEN`을 활용한 데이터 분류 및 `COALESCE()`를 활용한 NULL 처리
- `EXISTS`를 활용한 조건별 데이터 존재 여부 확인
- `BEGIN TRANSACTION`, `ROLLBACK`을 활용한 데이터 변경 및 복구 검증

## 실습 환경
- SQLite / DB Browser for SQLite
- 테스트 테이블: `users`, `orders`

## 파일 구성
| 파일 | 내용 |
|---|---|
| `01-Setup.sql` | 테스트 테이블 생성 및 샘플 데이터 입력 |
| `02-SQL-Validation.sql` | SQL 심화 데이터 검증 실습 6문제 |

## QA 검증 관점
- 조회 결과뿐 아니라 필터 조건 충족 여부 확인
- NULL 및 연관 데이터가 없는 예외 상황 검증
- 트랜잭션 실행 후 ROLLBACK을 통한 원본 데이터 복구 확인
