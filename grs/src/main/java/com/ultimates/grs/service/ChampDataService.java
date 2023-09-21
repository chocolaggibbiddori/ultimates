package com.ultimates.grs.service;

import com.ultimates.grs.data.dto.ChampDataDto;
import com.ultimates.grs.data.dto.UserDataDto;
import com.ultimates.grs.data.entity.ChampData;
import com.ultimates.grs.data.entity.UserData;
import com.ultimates.grs.repository.ChampRepository;
import com.ultimates.grs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChampDataService {
    private final ChampRepository champRepository;

    @Autowired
    public ChampDataService(ChampRepository champRepository) {
        this.champRepository = champRepository;
    }

    public ResponseEntity<List<ChampDataDto>> getUserDataFromDatabase() {
        List<ChampData> champDataList = champRepository.findAll();
        List<ChampDataDto> champDataDtoList = new ArrayList<>();

        for (ChampData champData : champDataList) {
            ChampDataDto champDataDto = new ChampDataDto();
            champDataDto.setIdx(champData.getIdx());


            champDataDtoList.add(champDataDto);
        }
        return new ResponseEntity<List<ChampDataDto>>(champDataDtoList, HttpStatus.OK);
    }
}