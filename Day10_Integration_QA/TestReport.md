# REPORT-001 — 최종 QA 검증 보고서

## 1. 프로젝트 개요
- **목적:** JSONPlaceholder의 사용자·게시글 API 응답을 Postman으로 검증하고, 별도로 구성한 SQLite 데이터의 정합성을 SQL과 Java로 확인하였습니다.
- **검증 범위:** 사용자·게시글 API의 상태코드, 데이터 타입, 필수 필드, 사용자 관계를 확인하고, SQLite 게시글의 사용자 참조 관계 및 제목 유효성과 Java 판정 결과를 검증하였습니다.

## 2. 테스트 환경
- API 테스트: Postman
- 공개 테스트 API: [JSONPlaceholder](https://jsonplaceholder.typicode.com/)
- DBMS: SQLite / DB 관리: DB Browser for SQLite
- 데이터 검증: SQL, Java
- 개발 환경: VS Code
- 테스트 데이터: JSONPlaceholder 응답을 참고해 별도로 구성한 SQLite 실습 데이터 및 의도적으로 추가한 이상 데이터

## 3. 테스트 수행 결과
| 구분 | 수행 범위 | 결과 |
| --- | --- | --- |
| Postman | API 테스트 4개 TC | 제출된 실행 결과 및 코드 검토 기준 완료 |
| SQL | 정합성 검증 쿼리 6개 | 첨부한 SQLite DB에서 6개 쿼리 직접 실행, 기대 결과 일치 |
| Java | 검증 데이터 9건 | 9 PASS / 0 FAIL (제출 코드 기준) |

## 4. 이상 데이터 분석
| 게시글 | 검출 근거 | 기대 판정 |
| --- | --- | --- |
| 202 | 존재하지 않는 사용자 ID 999 참조 | `INVALID_USER` |
| 203 | 제목이 공백 3개로 구성 | `INVALID_TITLE` |
| 204 | 제목이 NULL | `INVALID_TITLE` |

위 3건은 정합성 검증을 위해 의도적으로 구성한 데이터이며 실제 JSONPlaceholder 서비스에서 발견한 결함이 아닙니다.

## 5. 최종 결론
- **확인한 사항:** 사용자·게시글 API 응답을 검증하고, SQLite의 사용자 참조 관계와 제목 유효성을 확인하였습니다. 동일한 판정 규칙을 Java로 구현해 9개 테스트의 기대 결과와 실제 결과가 일치함을 확인하였습니다.
- **검증의 한계:** JSONPlaceholder의 POST 요청은 데이터를 영구 저장하지 않아 실제 API 서버의 DB 반영 여부를 검증할 수 없습니다. SQLite 데이터는 별도의 실습 환경입니다.
- **향후 개선 사항:** DB와 연동된 테스트 환경에서 API 요청 이후 데이터 저장 여부 및 정합성을 확인하고 반복 실행 가능한 자동화 검증을 확대할 예정입니다.
