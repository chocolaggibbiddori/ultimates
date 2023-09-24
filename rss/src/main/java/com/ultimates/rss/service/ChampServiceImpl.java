package com.ultimates.rss.service;

import com.ultimates.rss.dto.Champ;
import com.ultimates.rss.dto.KDA;
import com.ultimates.rss.dto.MostChamp;
import com.ultimates.rss.dto.Skill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChampServiceImpl implements ChampService {

    private final RestTemplateService restTemplateService;

    @Override
    public Champ getChampDetail(String champName) {
        int playCount = restTemplateService.getChampPlayCount(champName);
        int win = restTemplateService.getChampWin(champName);
        int lose = restTemplateService.getChampLose(champName);
        Skill skill = restTemplateService.getChampSkill(champName);
        KDA kda = restTemplateService.getChampKDA(champName);

        return new Champ(champName, playCount, win, lose, skill, kda);
    }

    @Override
    public List<MostChamp> getMostChampList(String username) {
        return null;
    }
}
