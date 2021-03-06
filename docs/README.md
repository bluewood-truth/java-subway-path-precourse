# 지하철 노선도 경로 조회 미션

* 등록된 지하철 노선도에서 경로를 조회하는 기능을 구현한다.

## 구현할 기능 목록

### 클래스 정의

- [x] 노선에 등록된 역 정보를 저장하는 일급 콜렉션을 만든다.

- [x] 가중치를 저장해두는 Repository를 만든다.
  - [x] 각 가중치는 거리, 시간을 저장한 Map을 변수로 갖는다.
  - [x] 두 역을 입력받아 거리, 시간 가중치를 반환하는 기능을 만든다.
- [x] 최단경로를 저장해두는 Repository를 만든다.
  - [x] 거리 기준, 시간 기준 경로를 각각 만들어둔다.
  - [x] 가중치 기준, 출발역과 도착역을 입력하면 해당 최단경로를 반환하는 기능을 만든다.

### 메뉴 표시 기능

- [x] 기능 목록을 출력한다.
- [x] 사용자 입력에 따라 해당 기능을 호출한다.
  -  **예외 사항**
     * [x] 사용자 입력에 해당하는 기능이 없을 경우
- [x] 경로 조회 결과를 표시한 뒤 메인 메뉴를 표시한다.
- [x] 메뉴에서 예외 발생 시 에러 메세지를 출력하고 해당 메뉴를 다시 표시한다.
- [x] 역 이름 입력 중 예외 발생 시 경로 기준 메뉴를 다시 표시한다.


#### 메뉴 구성

* 메인 화면
  * 경로 조회
    * 최단 거리
    * 최소 시간
    * 돌아가기
  * 종료

### 경로 조회 기능

#### 경로 기준 선택

- [x] 사용자로부터 최단 경로 계산에 어떤 가중치를 사용할지 입력받는다. (거리 or 시간)

#### 출발역과 도착역 입력

- [x] 사용자로부터 출발역을 입력받는다.
  - **예외사항**
    - [x] 역이 등록된 역 목록에 존재하지 않을 경우
- [x] 사용자로부터 도착역을 입력받는다.
  - **예외사항**
    - [x] 역이 등록된 역 목록에 존재하지 않을 경우
    - [x] 출발역과 동일할 경우

#### 최단 경로 계산

- [x] 입력받은 경로 기준, 출발역과 도착역으로 최단 경로를 구한다.
- [x] 최단 경로로부터 소요된 거리/시간을 구한다.
- [x] 최단 경로로부터 지나온 역 목록을 구한다.
- [x] 지나온 역 목록으로부터 선택하지 않은 나머지 가중치 기준의 총 소요값을 구한다.
  (i.g. 경로 기준으로 거리를 선택했다면, 산출된 최단 거리 경로로부터 소요 시간을 구한다.)

- [x] 계산된 결과를 출력한다.

<br>

## 프로그래밍 요구사항

- [x] [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)를 준수한다. (단 indent는 4)
- [x] indent depth는 2까지만 허용한다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] else, switch/case 예약어를 사용하지 않는다.
- [x] 예외 상황 시 `[ERROR]`로 시작하는 에러 문구를 출력한다.
- 프로그래밍 요구사항 - Application

  - [x] Application 클래스를 활용해 구현한다.
  - [x] Application의 패키지 구조는 변경하지 않는다.
  - [x] Application 클래스에 있는 Scanner를 사용하고 별도의 Scanner 객체를 만들지 않는다.
- 프로그래밍 요구사항 - Station, Line

  - [x] Station, Line 클래스를 활용하여 지하철역과 노선을 구현해야 한다.
  - [x] 제공하는 각 클래스의 기본 생성자를 추가할 수 없다.
  - [x] 필드(인스턴스 변수)인 name의 접근 제어자 private을 변경할 수 없다.
  - [x] 가능하면 setter 메소드(ex. setXXX)를 추가하지 않고 구현한다.
- 프로그래밍 요구사항 - StationRepository, LineRepository
  - [x] 필요 시 StationRepository, LineRepository 이 외 추가로 Repository를 만들 수 있다.
  - [x] 추가로 생성되는 객체에 대해서 XXXRepository 네이밍으로 저장 클래스를 추가한다.
  - [x] 객체들의 상태를 관리하기 위해서 XXXRepository 클래스를 활용해 저장 로직을 구현해야 한다.
  - [x] **작성된 메서드는 수정할 수 없고**, 필요에 따라 메서드를 자유롭게 추가할 수 있다.

