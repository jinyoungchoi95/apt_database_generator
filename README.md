## txt로 저장된 아파트 필요 정보를 필터링하여 데이터베이스에 저장하기 위한 프로그램

### Apt.java
- 입력할 아파트 데이터 정보를 넣는 클래스
- 행안부 데이터베이스에서 받은 txt파일 상 한 아파트의 정보가 29개이기 때문에 해당 값이 틀릴 경우 exception 발생

- 필요한 데이터는 해당 위치에 있는 데이터를 가져다 사용
- 실제 pdf상 정보는 1부터 시작하지만 list상 index는 0부터 시작하므로 유의

### DBConnection.java
- 데이터를 삽입할 데이터베이스에 대한 접근 정보가 담겨져 있음
- 현재 사용자가 실행중인 서버의 정보로 수정필요

### AptJdcRepository.java
- 데이터 삽입 쿼리
- apt 삽입 정보에 대한 수정이 필요할 경우 쿼리 수정 필요

### FileDownloader.java
- txt load용 클래스
- txt route를 입력하면 해당 경로에 있는 txt파일을 가져옴
- 경로는 절대경로로써 입력하면 사용 가능 (ex src/main/resources/~.txt)
- List를 구분짓는 단위는 enter(한칸 띄워쓰기)

### Main.java
- 주석이 달려있으므로 설명생략
