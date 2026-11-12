# Day 04 - SQL 데이터 검증

## 학습 내용
- `SELECT`, `WHERE`, `ORDER BY`를 활용한 조건별 데이터 조회
- `COUNT`, `SUM`, `GROUP BY`, `HAVING`을 활용한 집계 검증
- `INNER JOIN`으로 사용자·주문 테이블 연결
- API 응답과 DB 저장값 비교 및 데이터 불일치 분석

## 실습 환경
- SQLite / DB Browser for SQLite
- 테스트 테이블: `users`, `orders`

## 파일 구성
| 파일 | 내용 |
| --- | --- |
| `01-Setup.sql` | 테스트 테이블 생성 및 샘플 데이터 입력 |
| `02-SQL-Validation.sql` | SQL 데이터 조회·집계 및 정합성 검증 |



## 실행 결과
- ACTIVE 상태이며, 30세 이상 사용자 조회

<img width="310" height="191" alt="image" src="https://github.com/user-attachments/assets/c2e7212a-32f7-4768-bdd3-3385d9d50150" />


- 주문 상태별 건수 집계

<img width="361" height="182" alt="image" src="https://github.com/user-attachments/assets/190b3f32-94ec-4cb0-81a3-2d172eea447d" />


- 'PAID' 주문의 사용자별 결제 총액 중 20,000 이상 조회

<img width="363" height="275" alt="image" src="https://github.com/user-attachments/assets/cf6ad7e0-f847-4812-8582-6cc8a3e03e6a" />

## API 응답과 DB 상태 불일치 검증(가상 사례)
- API 요청: GET /users/103
- DB 저장값: BLOCKED
- API 응답값: ACTIVE
- 판정: FAIL (최신 상태 반환이 요구되는 경우)

- **추가 검증**
1. SQL을 사용하여 DB의 사용자 상태 재확인
2. 다른 사용자 조회를 통해 결함 발생 범위 확인
4. Postman에서 Cache-Control: no-cache 설정 후 API 재호출
6. 일정 간격으로 API를 재홀출하여 데이터 동기화 지연 여부 확인
7. API 서버와 DB의 연결 환경 및 데이터 소스 일치 여부 확인

- **검증 목적**

API 응답과 DB 데이터의 정합성을 확인하고, 캐시·동기화·환경 불일치 등 가능한 원인을 분석한다.
