# Day 10 — API 및 게시글 데이터 정합성 검증

Postman으로 JSONPlaceholder의 사용자·게시글 API 응답을 검증하고, SQLite에서 데이터 정합성을 분석한 뒤 동일한 판정 규칙을 Java로 구현한 종합 실습입니다.

## 사용 기술
- **Postman:** 상태코드·필수 필드·사용자 관계·배열 응답 검증, 컬렉션 변수 활용
- **SQLite / SQL:** 사용자 참조 관계, NULL 및 공백 제목, 종합 데이터 판정
- **Java:** 검증 로직 분리, 기대값/실제값 비교, 9개 테스트 결과 집계

## 검증 결과
| 도구 | 범위 | 결과 |
| --- | --- | --- |
| Postman | API-TC-001~004 | 4개 TC 검증 완료 |
| SQL | SQL-001~006 | 6개 쿼리 실행 · 기대 결과 일치 |
| Java | Post 201~209 | 9 PASS / 0 FAIL |

**실습용 이상 데이터:** Post 202 (`INVALID_USER`), Post 203·204 (`INVALID_TITLE`). 실제 서비스에서 발견된 결함이 아닙니다.
상세 내용은 [최종 보고서](TestReport.md)

## 파일 구성
- `Postman/`: 업로드한 SQA_API_TEST 컬렉션의 Day 10 요청 4개 포함 (baseUrl 기본값 설정)
- `SQL/Setup.sql`: 실습용 SQLite 테이블 및 데이터 구성
- `SQL/SQL01_User_Validation.sql`~`SQL06_Post_Validation.sql`: 목적별 개별 검증 쿼리
- `SQL/day10_SQL.db`: 실습 데이터베이스 원본
- `SQL/Validation.sql`: 6개 쿼리를 순서대로 실행하는 통합 스크립트
- `Java/`: 직접 작성한 Java 코드 4개
- `images/`: 제출된 Postman·초기 Java 실행 화면 (최종 Java 화면은 별도 추가 가능)
- `TestReport.md`: 최종 QA 검증 보고서

## 실행 안내
- Postman: `Postman/Day10_API_Integration_Test.postman_collection.json`을 Import한 뒤, 컬렉션 내 `DAY10_API_Integration_Test` 폴더의 요청을 순서대로 실행합니다. `baseUrl` 기본값은 JSONPlaceholder로 설정했습니다.
- SQLite: `SQL/day10_SQL.db`를 DB Browser for SQLite로 열고 `SQL/SQL01_User_Validation.sql`부터 `SQL/SQL06_Post_Validation.sql`까지 순서대로 실행하거나 `SQL/Validation.sql`을 실행합니다. `Setup.sql`은 기존 테이블을 삭제하고 다시 생성하므로 초기화가 필요할 때만 실행합니다.
- Java: `Java/` 폴더에서 `javac -encoding UTF-8 *.java` 후 `java App` 실행합니다.

## 실습 한계
JSONPlaceholder의 POST는 영구 저장을 수행하지 않으며, SQLite는 원격 서비스 DB와 연결되어 있지 않습니다. 따라서 이번 결과는 API 응답 검증과 별도 실습 데이터 정합성 검증이며 E2E 데이터 저장 검증은 아닙니다.
