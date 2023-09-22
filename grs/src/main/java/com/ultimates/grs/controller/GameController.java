package com.ultimates.grs.controller;

import com.ultimates.grs.data.dto.ChampOddsDto;
import com.ultimates.grs.data.dto.GameDataDto;
import com.ultimates.grs.data.entity.ChampData;
import com.ultimates.grs.data.entity.GameData;
import com.ultimates.grs.service.GameDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/grs")
public class GameController {

    private final GameDataService gameDataService;

    @Autowired
    public GameController(GameDataService gameDataService) {
        this.gameDataService = gameDataService;
    }

    // 모든 게임에 대한 모든 정보
    @GetMapping("/gamedata")
    public ResponseEntity<List<GameDataDto>> getGameData() {

        ResponseEntity<List<GameDataDto>> responseEntity = gameDataService.getGameDataAll();
        return responseEntity;
    }

    // 검색한 챔피언에 대한 킬데스어시
    @GetMapping("/gamedata/champodds/{champName}")
    public ResponseEntity<List<ChampOddsDto>> getChampOdds(@PathVariable("champName") String champName) {
        ResponseEntity<List<ChampOddsDto>> responseEntity = gameDataService.getChampOdds(champName);

        return responseEntity;
    }

    // 검색한 유저가 했던 게임 정보들
    @GetMapping("/gamedata/{userName}")
    public ResponseEntity<List<GameDataDto>> getUserGameRecord(@PathVariable("userName") String userName) {
        ResponseEntity<List<GameDataDto>> responseEntity = gameDataService.getUserGameRecord(userName);

        return responseEntity;
    }
}