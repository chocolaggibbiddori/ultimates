package com.ultimates.grs.controller;

import com.ultimates.grs.data.dto.GameDataDto;
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
@RequestMapping("/ckjl")
public class GameController {

    private final GameDataService gameDataService;

    @Autowired
    public GameController(GameDataService gameDataService) {
        this.gameDataService = gameDataService;
    }

    @GetMapping("/gamedata")
    public ResponseEntity<List<GameDataDto>> getGameData() {

        ResponseEntity<List<GameDataDto>> responseEntity = gameDataService.getGameDataFromDatabase();
        return responseEntity;
    }
}