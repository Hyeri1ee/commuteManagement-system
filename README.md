# 미니 프로젝트 

###  :hamburger: 설명

:one: 사용될 기술 스택
- 자바 17 버전
- Spring Boot 3.x.x 버전
- JPA
- MySQL
- html, css, js

:two: 프로젝트 설명

## 단계 1

```angular2html
1. 구현되어야 하는 기능 (api)
```
- 팀 등록 기능
  - 회사에 있는 팀을 등록할 수 있어야 합니다. 팀이 가져야할 필수 정보는 다음과 같습니다.
  - ```팀 이름```
- 직원 등록 기능
  - 직원을 등록할 수 있어야 합니다. 직원이 가져야할 필수 정보는 다음과 같습니다.
  - ```직원 이름```
  - ```팀의 매니저인지 매니저가 아닌지 여부```
  - ```회사에 들어온 일자```
  - ```생일```
- 팀 조회 기능
  - 모든 팀의 정보를 한 번에 조회할 수 있어야 합니다.

- 직원 조회 기능
  - 모든 직원의 정보를 한 번에 조회할 수 있어야 합니다.

```angular2html
2. 기본적인 커밋(commit) 형식

[the type] [message]
```
```feat```: 새로운 기능이 있을 때

```fix```: 버그 수정

```docs```: 문서 내용을 수정할 때

```style```: 포맷의 변경, 세미콜론 누락 등 코드 변화가 없을 때

```refactor```: 코드를 리팩터링할 때

```test```: 프로덕션 코드 변경이 없는 테스트 코드의 추가, 리팩터링의 테스트

```chore```: 프로덕션 코드 변경이 없는 빌드 태스크 업데이트, 패키지의 config 변경

:three: 작업 순서

- [swagger](http://localhost:8080/swagger-ui/index.html) 문서화 적용
- 팀 등록 기능 api 개발
- db 연결
- 단계 1 api 추가 + 직원 팀 배정 api 추가

:four: 마무리

```angular2html
1 단계 api 설명
```
swagger 에도 올려놓았지만 1단계에서 구현한 api를 설명하면 다음과 같다.
- (POST) /v1/team/create : 팀 이름을 넣어 팀 등록을 한다.
- (GET) /v1/team/overview : 등록된 팀 전체 조회를 한다.
- (POST) /v1/conlleague/putTeam : 직원을 등록된 팀에 배정 한다. ```(개인적으로 추가한 api)```
- (POST) /v1/colleague/create : 직원 정보를 넣어 직원 등록을 한다.
- (GET) /v1/colleague/overview : 등록된 직원 전체 조회를 한다.



## 단계 2

