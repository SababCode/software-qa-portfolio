# Day 07 - Java 기초 및 QA 검증

## 학습 내용

Java 기본 문법을 활용하여 HTTP 상태코드, 응답 시간, 다중 테스트 케이스를 검증하는 프로그램을 구현했습니다.

## 주요 Java 문법

| 문법 | 활용 내용 |
|---|---|
| 변수 및 자료형 | `int`, `double`, `boolean`, `String` |
| 조건문 | `if-else`를 활용한 PASS/FAIL 판정 |
| 반복문 | `for`를 이용한 다중 테스트 |
| 배열 | 기대값과 실제값 관리 |
| 메서드 | 검증 로직 분리 및 재사용 |
| `return` | 검증 결과 반환 |
| `try-catch` | 잘못된 입력에 대한 예외 처리 |
| `throw` | `IllegalArgumentException` 발생 |

## 주요 검증 항목

- HTTP 상태코드 일치 여부
- API 응답 시간 및 경계값
- 다중 테스트 케이스 PASS/FAIL 판정 및 결과 집계
- 배열 길이 불일치 및 `null` 입력 예외 처리
- 음수 및 NaN 응답 시간 입력 검증

## 실습 환경

- 언어: Java
- 개발 도구: Visual Studio Code
- 검증 방식: Java 콘솔 기반 테스트
