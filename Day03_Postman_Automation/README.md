# Day 03 - Postman API Automation

## 학습 내용
Postman Collection Runner를 활용한 API 자동화 테스트 및 데이터 기반 반복 검증

## 주요 학습 항목
- 정상 및 예외 상황 API 테스트
- HTTP 상태코드와 응답 데이터 검증
- Collection Runner를 이용한 반복 실행
- 배열 및 조건문을 활용한 데이터 기반 테스트
- 컬렉션 변수와 로컬 변수 관리

## 주요 JavaScript 문법

| 문법 | 설명 |
|---|---|
| `pm.test()` | 테스트 정의 |
| `pm.expect()` | 기대 결과 검증 |
| `pm.response.json()` | 응답 JSON 데이터 추출 |
| `pm.collectionVariables.set()` | 컬렉션 변수 저장 |
| `pm.variables.set()` | 로컬 변수 설정 |
| `pm.info.iteration` | 현재 반복 실행 번호 확인 |
| `if / else if` | 조건별 검증 처리 |
| `Number()` | 숫자형 변환 |

## 실습 환경
- Postman
- JavaScript
- JSONPlaceholder REST API
