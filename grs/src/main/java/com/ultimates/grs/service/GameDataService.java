package com.ultimates.grs.service;

import com.ultimates.grs.data.dto.ChampOddsDto;
import com.ultimates.grs.data.dto.GameDataDto;
import com.ultimates.grs.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameDataService {

    private final GameRepository gameRepository;

    @Autowired
    public GameDataService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public ResponseEntity<List<GameDataDto>> getAllGameData() {
        List<GameDataDto> gameDataDtoList = gameRepository.findGameDataDtoList();
        return new ResponseEntity<>(gameDataDtoList, HttpStatus.OK);
    }

    public ResponseEntity<List<ChampOddsDto>> getChampOdds(String champName) {
        List<ChampOddsDto> champOddsList = gameRepository.findChampOddsDtoListByPlayChamp(champName);
        return new ResponseEntity<>(champOddsList, HttpStatus.OK);
    }

    public ResponseEntity<List<GameDataDto>> getUserGameData(String userName) {
        List<GameDataDto> gameDataDtoList = gameRepository.findByUserName(userName);
        return new ResponseEntity<>(gameDataDtoList, HttpStatus.OK);
    }

    public ResponseEntity<List<GameDataDto>> getUserInGameData(Integer gameNumber) {
        List<GameDataDto> gameDataDtoList = gameRepository.findByGameNumber(gameNumber);
        return new ResponseEntity<>(gameDataDtoList, HttpStatus.OK);
    }

    public ResponseEntity<List<GameDataDto>> getSpecifiedGameData(Integer gameNumber) {
        List<GameDataDto> gameDataDtoList = gameRepository.findByGameNumber(gameNumber);
        return new ResponseEntity<>(gameDataDtoList, HttpStatus.OK);
    }
}
