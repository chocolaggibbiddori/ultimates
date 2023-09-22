package com.ultimates.grs.controller;

import com.ultimates.grs.data.dto.ChampDataDto;
import com.ultimates.grs.data.dto.UserDataDto;
import com.ultimates.grs.data.entity.ChampData;
import com.ultimates.grs.data.entity.GameData;
import com.ultimates.grs.service.ChampDataService;
import com.ultimates.grs.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grs")
public class ChampController {

    private final ChampDataService champDataService;

    @Autowired
    public ChampController(ChampDataService champDataService) {
        this.champDataService = champDataService;
    }

    @GetMapping("/champdata")
    public ResponseEntity<List<ChampDataDto>> getChampDataAll() {

        ResponseEntity<List<ChampDataDto>> responseEntity = champDataService.getChampDataFromDatabase();
        return responseEntity;
    }

    @GetMapping("/champdata/{champName}")
    public ChampData getChampSearch(@PathVariable("champName") String champName) {
        ChampData responseEntity = champDataService.getChampDataOneFromDatabase(champName);

        return responseEntity;
    }


}