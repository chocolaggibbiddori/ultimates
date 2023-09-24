package com.ultimates.grs.data;

import com.ultimates.grs.data.entity.ChampData;
import com.ultimates.grs.repository.ChampRepository;
import com.ultimates.grs.repository.GameRepository;
import com.ultimates.grs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Component
public class DBInit {

    private final ChampRepository champRepository;
    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        champInit();
        gameInit();
        userInit();
    }

    private void champInit() {
        List<ChampData> champDataList = new ArrayList<>();

        champDataList.add(new ChampData("리신", "충무공", "명량해전", "거북선 소환", "학익진"));
        champDataList.add(new ChampData("아리", "대차륜", "권각술", "무영각", "경공술"));
        champDataList.add(new ChampData("트페", "격려", "회전창", "화염찌르기", "바위부수기"));
        champDataList.add(new ChampData("말파", "뇌전탄", "화살비", "추적자의 화살", "용사냥꾼"));
        champDataList.add(new ChampData("사일", "흩뿌리기", "난치기", "해그리기", "범가르기"));
        champDataList.add(new ChampData("알리", "약초", "진찰", "명의", "지혈"));

        champRepository.saveAll(champDataList);
    }

    private void gameInit() {
        // champInit()이랑 동일하게
    }

    private void userInit() {
        // champInit()이랑 동일하게
    }
}
