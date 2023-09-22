package com.ultimates.grs.service;

import com.ultimates.grs.data.dto.ChampDataDto;
import com.ultimates.grs.data.entity.ChampData;
import com.ultimates.grs.data.entity.GameData;
import com.ultimates.grs.repository.ChampRepository;
import com.ultimates.grs.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChampDataService {
    private final ChampRepository champRepository;
    private final GameRepository gameRepository;

    @Autowired
    public ChampDataService(ChampRepository champRepository, GameRepository gameRepository) {
        this.champRepository = champRepository;
        this.gameRepository = gameRepository;
    }

    public ResponseEntity<List<ChampDataDto>> getChampDataFromDatabase() {
        List<ChampData> champDataList = champRepository.findAll();
        List<ChampDataDto> champDataDtoList = new ArrayList<>();

        for (ChampData champData : champDataList) {
            ChampDataDto champDataDto = new ChampDataDto();
            champDataDto.setIdx(champData.getIdx());
            champDataDto.setChampName(champData.getChampName());
            champDataDto.setQSkill(champData.getQSkill());
            champDataDto.setWSkill(champData.getWSkill());
            champDataDto.setESkill(champData.getESkill());
            champDataDto.setRSkill(champData.getRSkill());


            champDataDtoList.add(champDataDto);
        }
        return new ResponseEntity<List<ChampDataDto>>(champDataDtoList, HttpStatus.OK);
    }

    public ChampData getChampDataOneFromDatabase(String champName) {
        ChampData champData = champRepository.findByChampName(champName);

        return champRepository.findByChampName(champName);
    }
}