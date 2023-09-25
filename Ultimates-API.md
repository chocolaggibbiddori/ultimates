<h1>GameData</h1>

|Mapping|Functional Description|ResponseEntity<>|
|---|---|---|
|GetMapping("/grs/gamedata")|AllGameData|List<`GameDataDto>|
|GetMapping("/grs/gamedata/champodds/{champName})|특정 챔피언  K/D/A/WinRate|List<`ChampOddDto>|
|GetMapping("/grs/gamedata/{userName})|유저가 참여한 게임들|List<`GameDataDto>|
|GetMapping("/grs/gamedata/{userName}/{gameNumber})|유저가 참여한 특정게임|List<`GameDataDto>|
|GetMapping("/gamedata/InGameData/{gameNumber}")|특정 게임에 참여한 유저들의 게임데이터|List<`GameDataDto>|

---

```java
class GameDataDto{

	Long idx;                // DB 에서 PK로 사용하기 위한 용도 Idx 
    String userName;         // 유저이름
    int gameNumber;          // 진행된 게임의 고유번호
    Date startTime;          // 게임이 시작된 시간
    Date endTime;            // 게임이 끝난 시간
    String playChamp;        // 유저가 플레이한 챔피언 이름
    int killCnt;             // Kill 카운트
    int deathCnt;            // Death 카운트
    int assistCnt;           // Assist 카운트
    boolean win;             // 승패 여부
    int atkDmg;              // 가한 데미지
    int recDmg;              // 받은 데미지
    
}

```


---
```java

class ChampOddsDto {

	String playChamp; // 플레이한 챔피언 이름
    int killCnt;      // Kill 카운트
    int deathCnt;     // Death 카운트
    int assistCnt;    // Assist 카운트
    boolean win;      // 승패 여부

}

```


---

 <H1>UserData</H1>

---

<h3>Mapping</h3>

|Mapping|Functional Description|ResponseEntity<>|
|---|---|---|
|GetMapping("/grs/userdata")|AllUserData|List<`UserDataDto>|
|GetMapping("/grs/userdata/{userName})|특정 유저의 레벨 ,티어 데이터|UserDataDto|



---
```java

class UserDataDto{

    Long idx;         // Pk로 이용하기 위한 Index
    int gameNum;      // 진행된 게임의 고유 번호 
    int lv;           // 유저의 레벨 정보
    String userName;  // 유저 이름
    int tier;         // 유저의 티어 정보

}

```
___

<H1>ChampionData</h1>

|Mapping|Functional Description|ResponseEntity<>|
|---|---|---|
|GetMapping("/grs/champdata")|AllchampData|List<`ChampDataDto>|
|GetMapping("/grs/champdata/{chmapName})|특정 챔피언의 스킬 데이터|ChampDataDto|

___

```java

class ChampDataDto {

    Long idx;           // Pk로 이용하기 위한 Index
    String champName;   // 챔피언 이름
    String qSkill;      // q 스킬 정보
    String wSkill;      // w 스킬 정보
    String eSkill;      // e 스킬 정보
    String rSkill;      // r 스킬 정보

}

```
