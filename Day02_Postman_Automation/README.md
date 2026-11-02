# 2일차 - Postman API 연계 및 자동화

## 학습 내용

- 컬렉션 변수를 활용한 API 요청 간 데이터 전달
- JavaScript 기반 API 응답 자동 검증
- 정상 및 비정상 응답에 대한 기대 결과 검증
- Collection Runner를 활용한 테스트 일괄 실행

## 주요 JavaScript 문법

| 문법 | 설명 |
|---|---|
| `const` | 변경하지 않을 변수 선언 |
| `function () {}` | 함수 정의 |
| `Number()` | 값을 숫자형으로 변환 |
| `typeof` | 값의 자료형 확인 |
| `console.log()` | 콘솔에 값 출력 |

## Postman 주요 함수

| 함수 | 설명 |
|---|---|
| `pm.test()` | 자동 테스트 정의 |
| `pm.expect()` | 기대 결과 검증 |
| `pm.response.json()` | JSON 응답 데이터 추출 |
| `pm.response.to.have.status()` | HTTP 상태 코드 검증 |
| `pm.collectionVariables.set()` | 컬렉션 변수 저장 |
| `pm.collectionVariables.get()` | 컬렉션 변수 조회 |
| `pm.collectionVariables.unset()` | 컬렉션 변수 삭제 |

## 학습 정리
컬렉션 변수를 활용해 API 요청 간 데이터를 전달하고, JavaScript 검증 함수를 이용해 응답 데이터와 상태 코드를 자동으로 확인하는 방법을 학습했습니다.
또한 기대 결과에 따라 404 응답도 정상적인 테스트 결과로 판단할 수 있음을 이해했습니다.
