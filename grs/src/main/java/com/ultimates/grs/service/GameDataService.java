package com.ultimates.grs.service;

import com.ultimates.grs.data.dto.GameDataDto;
import com.ultimates.grs.data.entity.ChampData;
import com.ultimates.grs.data.entity.GameData;
import com.ultimates.grs.repository.GameRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameDataService {
    private final GameRepository gameRepository;

    @Autowired
    public GameDataService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public ResponseEntity<List<GameDataDto>> getGameDataFromDatabase() {
        List<GameData> gameDataList = gameRepository.findAll();
        List<GameDataDto> gameDataDtoList = new ArrayList<>();

        for (GameData gameData : gameDataList) {
            GameDataDto gameDataDto = new GameDataDto();
            gameDataDto.setIdx(gameData.getIdx());
            gameDataDto.setUserName(gameData.getUserName());
            gameDataDto.setGameNumber(gameData.getGameNumber());
            gameDataDto.setStartTime(gameData.getStartTime());
            gameDataDto.setEndTime(gameData.getEndTime());
            gameDataDto.setPlayChamp(gameData.getPlayChamp());
            gameDataDto.setKillCnt(gameData.getKillCnt());
            gameDataDto.setDeathCnt(gameData.getDeathCnt());
            gameDataDto.setAssistCnt(gameData.getAssistCnt());
            gameDataDto.setWin(gameData.isWin());
            gameDataDto.setAtkDmg(gameData.getAtkDmg());
            gameDataDto.setRecDmg(gameData.getRecDmg());

            gameDataDtoList.add(gameDataDto);
        }
        return new ResponseEntity<>(gameDataDtoList, HttpStatus.OK);
    }
    public ResponseEntity<List<GameDataDto>> getChampDataInGameFromDatabase(String champName){
        List<GameData> gameDataList = gameRepository.findByPlayChamp(champName);
        List<GameDataDto> gameDataDtoList = new ArrayList<>();
        for (GameData gameData : gameDataList) {
            GameDataDto gameDataDto = new GameDataDto();
            gameDataDto.setIdx(gameData.getIdx());
            gameDataDto.setUserName(gameData.getUserName());
            gameDataDto.setGameNumber(gameData.getGameNumber());
            gameDataDto.setStartTime(gameData.getStartTime());
            gameDataDto.setEndTime(gameData.getEndTime());
            gameDataDto.setPlayChamp(gameData.getPlayChamp());
            gameDataDto.setKillCnt(gameData.getKillCnt());
            gameDataDto.setDeathCnt(gameData.getDeathCnt());
            gameDataDto.setAssistCnt(gameData.getAssistCnt());
            gameDataDto.setWin(gameData.isWin());
            gameDataDto.setAtkDmg(gameData.getAtkDmg());
            gameDataDto.setRecDmg(gameData.getRecDmg());

            gameDataDtoList.add(gameDataDto);
        }

        return new ResponseEntity<>(gameDataDtoList, HttpStatus.OK);
    }
}