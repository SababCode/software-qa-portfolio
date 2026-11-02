# 1일차 - Postman API 응답 자동 검증

## 학습 내용

- REST API의 GET 요청 및 HTTP 상태 코드 이해
- JavaScript 기반 API 응답 자동 검증
- JSON 응답 데이터 추출 및 필드 확인
- 데이터 값과 자료형 검증
- 정상 및 비정상 조회에 대한 기대 결과 검증

## 주요 JavaScript 문법

| 문법 | 설명 |
|---|---|
| `const` | 재할당할 수 없는 변수 선언 |
| `function () {}` | 함수 정의 |
| `data.id` | 객체의 특정 속성에 접근 |

## Postman 주요 함수

| 함수 | 설명 |
|---|---|
| `pm.test()` | 자동 테스트 정의 |
| `pm.expect()` | 기대 결과 검증 |
| `pm.response.json()` | JSON 응답 데이터 추출 |
| `pm.response.to.have.status()` | HTTP 상태 코드 검증 |
| `.to.eql()` | 실제 값과 기대값의 일치 여부 검증 |
| `.to.have.property()` | 특정 필드 존재 여부 확인 |
| `.to.be.a()` | 데이터 자료형 검증 |

## 학습 정리

Postman과 JavaScript를 활용하여 API 응답의 상태 코드, 데이터 값, 필수 필드 및 자료형을 자동 검증하는 방법을 학습했다.

정상 조회(200)와 존재하지 않는 데이터 조회(404)를 검증하며, API의 기대 결과를 기준으로 PASS/FAIL을 판단하는 방법을 이해했다.
