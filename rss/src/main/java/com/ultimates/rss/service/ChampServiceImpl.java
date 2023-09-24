package com.ultimates.rss.service;

import com.ultimates.rss.dto.Champ;
import com.ultimates.rss.dto.KDA;
import com.ultimates.rss.dto.MostChamp;
import com.ultimates.rss.dto.Skill;
import com.ultimates.rss.dto.api.response.GameData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        Map<String, MostChamp> map = new HashMap<>();
        List<GameData> gameDataList = restTemplateService.getGameDataList(username);

        for (GameData gameData : gameDataList) {
            String champName = gameData.getPlayChamp();
            MostChamp mostChamp = map.getOrDefault(champName, new MostChamp(champName));
            mostChamp.addPlayCount();
            if (gameData.isWin()) mostChamp.addWinCount();
            mostChamp.addKill(gameData.getKillCnt());
            mostChamp.addDeath(gameData.getDeathCnt());
            mostChamp.addAssist(gameData.getAssistCnt());
            map.put(champName, mostChamp);
        }

        return map.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getPlayCount(), e1.getValue().getPlayCount()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
