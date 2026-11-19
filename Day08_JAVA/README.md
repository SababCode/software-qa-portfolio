# Day 08 - Java 객체지향 및 테스트 코드 구조화

## 학습 내용

Java 객체지향 프로그래밍을 활용하여 테스트 데이터와 검증 로직을 분리하고, 재사용 가능한 QA 테스트 코드를 구현했습니다.

## 주요 학습 문법

- **Class / Object**: 클래스 정의 및 객체 생성
- **Constructor**: 생성자를 통한 필드 초기화 및 유효성 검사
- **Encapsulation**: `private` 필드와 `public` 메서드를 이용한 접근 제어
- **Static**: 객체 생성 없이 공통 검증 메서드 호출
- **Getter**: 객체의 테스트 데이터 조회
- **Array / for**: 테스트 케이스 배열 구성 및 반복 검증
- **try-catch / throw**: 예외 발생 및 처리
- **String.format()**: 테스트 케이스 ID 형식 지정

## 파일 구성

| 파일 | 설명 |
|---|---|
| `App.java` | 테스트 실행, TC 번호 관리 및 결과 집계 |
| `ApiValidator.java` | 상태 코드, 응답 시간 및 오류 코드 검증 |
| `TestCase.java` | 테스트 케이스 데이터 관리 |

## 학습 환경

- Java
- Visual Studio Code
- Git / GitHub
