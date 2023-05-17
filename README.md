# Tailable, FlUX, SSE를 활용한 채팅 애플리케이션 연습

### 사용 기술 스택
- SpringBoot
- MongoDB
- SSE
- FLUX

### 기술스택 사용 이유
- 네티 서버(비동기 서버)를 사용하게 될경우 DB도 비동기 DB를 사용해야 한다.
  - (mysql도 r2dbc 라이브러리를 사용할경우 가능)
  - MongoDb(NOSQL - NotOnlySql)을 선택했다.
- http vs SSE
  - http 프로토콜은 요청을 보내고 응답을 할시 연결을 끊어버린다.
  - SSE 프로토콜은 응답을 하게 될경우 요청은 끊어버리지만 응답은 계속 유지시킨다.
- FLUX & @Tailable
  - 하나의 클라이턴트가 쿼리를 요청에 조회를 하면 서버가 요청을 받아 처리해 반환해주고 커서를 닫지 않는다.
  - 다른 클라이턴트가 쿼리저장 요청을 하면 서버가 요청을 받아 닫히지 않은 커서에 저장된 쿼리를 그대로 controller가 flux로 흘려보내준다.



> 유튜브 '메타코딩'의 강의를 보고 만들었습니다