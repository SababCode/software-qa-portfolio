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

- 내용: "DB에서 user_id 103의 상태가 'BLOCKED' 상태로 확인했었는데 GET 메소드로 users/103 을 조회했을때, status가 'ACTIVE'로 반환되고 있다 추가 확인 방법은?"
1. DB에서 103 user 상태를 조회
<img width="283" height="134" alt="image" src="https://github.com/user-attachments/assets/d47537a9-9c51-4b94-82e9-f50b514d2918" />

2. 다른 유저 정보도 조회해보기
<img width="288" height="247" alt="image" src="https://github.com/user-attachments/assets/9faa16ed-1e44-4933-be03-67ce406e3709" />

4. GET 메소드가 캐시를 사용하는 가능성이 존재하여 postman -> Headers에서 환경 설정 (KEY = Cache-Control / Value = no-cache)
<img width="718" height="180" alt="image" src="https://github.com/user-attachments/assets/504ee8dc-e264-4319-b81a-7ec4f918becd" />

6. 데이터 동기화 시간 확인 (일정 간격으로 재호출하여 반영되는데 걸리는 시간 파악
7. 서버 환경과 DB 환경이 다른지 확인 등

