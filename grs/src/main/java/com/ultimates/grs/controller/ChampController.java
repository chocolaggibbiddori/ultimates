package com.ultimates.grs.controller;

import com.ultimates.grs.data.dto.ChampDataDto;
import com.ultimates.grs.service.ChampDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grs/champdata")
public class ChampController {

    private final ChampDataService champDataService;

    @Autowired
    public ChampController(ChampDataService champDataService) {
        this.champDataService = champDataService;
    }

    // 모든 챔피언 리스트
    @GetMapping
    public ResponseEntity<List<ChampDataDto>> getChampDataAll() {
        return champDataService.getChampDataFromDatabase();
    }

    // 검색한 챔피언이름 기준으로 챔피언 정보
    @GetMapping("/{champName}")
    public ChampDataDto getChampSkillSet(@PathVariable("champName") String champName) {
        return champDataService.getChampSkillFromDatabase(champName);
    }
}
