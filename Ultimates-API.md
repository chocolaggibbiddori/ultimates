<h1>GameData</h1>

|Mapping|Functional Description|ResponseEntity<>|
|---|---|---|
|GetMapping("/grs/gamedata")|AllGameData|[[List<GameDataDto>]]|
|GetMapping("/grs/gamedata/champodds/{champName})|특정 챔피언 K/D/A/WinRate|[[List<ChampOddDto>]]|
|GetMapping("/grs/gamedata/{userName})|유저가 참여한 게임들|[[List<GameDataDto>]]|
|GetMapping("/grs/gamedata/{userName}/{gameNumber})|유저가 참여한 특정게임|[[List<GameDataDto>]]|
|GetMapping("/gamedata/InGameData/{gameNumber}")|특정 게임에 참여한 유저들의 게임데이터|[[List<GameDataDto>]]|

---

GameDataDto{

	Long idx;
    String userName;
    int gameNumber;
    Date startTime;
    Date endTime;
    String playChamp;
    int killCnt;
    int deathCnt;
    int assistCnt;
    boolean win;
    int atkDmg;
    int recDmg;
    
}

---

ChampOddsDto {

	String playChamp;
    int killCnt;
    int deathCnt;
    int assistCnt;
    boolean win;

}

---

 <H1>UserData</H1>

---

<h3>Mapping</h3>

|Mapping|Functional Description|ResponseEntity<>|
|---|---|---|
|GetMapping("/grs/userdata")|AllUserData|[[List<UserDataDto>]]|
|GetMapping("/grs/userdata/{userName})|특정 유저의 레벨 ,티어 데이터|[[UserDataDto]]|



---
UserDataDto{

    Long idx;
    int gameNum;
    int lv;
    String userName;
    int tier;

}
___
<H1>ChampionData</h1>

|Mapping|Functional Description|ResponseEntity<>|
|---|---|---|
|GetMapping("/grs/champdata")|AllchampData|[[List<ChampDataDto>]]|
|GetMapping("/grs/champdata/{chmapName})|특정 챔피언의 스킬 데이터|[[ChampDataDto]]|

___
ChampDataDto {

    Long idx;
    String champName;
    String qSkill;
    String wSkill;
    String rSkill;

}