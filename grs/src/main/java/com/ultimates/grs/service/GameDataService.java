package com.ultimates.grs.service;

import com.ultimates.grs.data.dto.ChampOddsDto;
import com.ultimates.grs.data.dto.GameDataDto;
import com.ultimates.grs.data.entity.ChampData;
import com.ultimates.grs.data.entity.GameData;
import com.ultimates.grs.repository.GameRepository;

import com.ultimates.grs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameDataService {
    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    @Autowired
    public GameDataService(GameRepository gameRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }


    public ResponseEntity<List<GameDataDto>> getAllGameData() {
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

    public ResponseEntity<List<ChampOddsDto>> getChampOdds(String champName){
        List<GameData> champDataList = gameRepository.findByPlayChamp(champName);
        List<ChampOddsDto> champOddsList = new ArrayList<>();
        for (GameData champOdds : champDataList) {
            ChampOddsDto champOddsDto = new ChampOddsDto();
            champOddsDto.setPlayChamp(champOdds.getPlayChamp());
            champOddsDto.setKillCnt(champOdds.getKillCnt());
            champOddsDto.setDeathCnt(champOdds.getDeathCnt());
            champOddsDto.setAssistCnt(champOdds.getAssistCnt());
            champOddsDto.setWin(champOdds.isWin());

            champOddsList.add(champOddsDto);
        }

        return new ResponseEntity<>(champOddsList, HttpStatus.OK);
    }

    public ResponseEntity<List<GameDataDto>> getUserGameRecord(String userName){
        List<GameData> gameDataList = gameRepository.findByUserName(userName);
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
        return new ResponseEntity<List<GameDataDto>>(gameDataDtoList, HttpStatus.OK);
    }
    public ResponseEntity<List<GameDataDto>> getUserGameData(String userName) {
        List<GameData> gameDataList = gameRepository.findByUserName(userName);
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
        }return new ResponseEntity<List<GameDataDto>>(gameDataDtoList, HttpStatus.OK);
    }

    public ResponseEntity<List<GameDataDto>> getAllUserInGameData(String userName, Integer gameNumber) {
        List<GameData> gameDataList = gameRepository.findByUserNameAndGameNumber(userName, gameNumber);
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
        return new ResponseEntity<List<GameDataDto>>(gameDataDtoList, HttpStatus.OK);
    }
    public ResponseEntity<List<GameDataDto>> getSpectifiedGameData(Integer gameNumber) {
        List<GameData> gameDataList = gameRepository.findByGameNumber(gameNumber);
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
        return new ResponseEntity<List<GameDataDto>>(gameDataDtoList, HttpStatus.OK);
    }

}