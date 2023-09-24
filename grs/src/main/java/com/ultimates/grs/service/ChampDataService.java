package com.ultimates.grs.service;

import com.ultimates.grs.data.dto.ChampDataDto;
import com.ultimates.grs.repository.ChampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampDataService {

    private final ChampRepository champRepository;

    @Autowired
    public ChampDataService(ChampRepository champRepository) {
        this.champRepository = champRepository;
    }

    public ResponseEntity<List<ChampDataDto>> getChampDataFromDatabase() {
        List<ChampDataDto> champDataDtoList = champRepository.findChampDataDtoList();
        return new ResponseEntity<>(champDataDtoList, HttpStatus.OK);
    }

    public ChampDataDto getChampSkillFromDatabase(String champName) {
        return champRepository.findByChampName(champName);
    }
}
