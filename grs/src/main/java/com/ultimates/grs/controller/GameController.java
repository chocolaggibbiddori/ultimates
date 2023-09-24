package com.ultimates.grs.controller;

import com.ultimates.grs.data.dto.ChampOddsDto;
import com.ultimates.grs.data.dto.GameDataDto;
import com.ultimates.grs.service.GameDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
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
        return gameDataService.getAllGameData();
    }

    // 검색한 챔피언에 대한 킬데스어시
    @GetMapping("/gamedata/champodds/{champName}")
    public ResponseEntity<List<ChampOddsDto>> getChampOdds(@PathVariable("champName") String champName) {
        return gameDataService.getChampOdds(champName);
    }

    @GetMapping("/gamedata/{userName}")
    public ResponseEntity<List<GameDataDto>> getUserGameData(@PathVariable("userName") String userName) {
        return gameDataService.getUserGameData(userName);
    }

    @GetMapping("/gamedata/{userName}/{gameNumber}")
    public ResponseEntity<List<GameDataDto>> getPlayWithGameData(@PathVariable("userName") String userName, @PathVariable("gameNumber") Integer gameNumber) {
        return gameDataService.getAllUserInGameData(userName, gameNumber);
    }

    @GetMapping("/gamedata/InGameData/{gameNumber}")
    public ResponseEntity<List<GameDataDto>> getSrcNumberOfGameData(@PathVariable("gameNumber") Integer gameNumber) {
        return gameDataService.getSpectifiedGameData(gameNumber);
    }
}
