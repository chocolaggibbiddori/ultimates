package com.ultimates.rss.service;

import com.ultimates.rss.Tier;
import com.ultimates.rss.dto.KDA;
import com.ultimates.rss.dto.Skill;
import com.ultimates.rss.dto.api.response.ChampData;
import com.ultimates.rss.dto.api.response.ChampSkillData;
import com.ultimates.rss.dto.api.response.GameData;
import com.ultimates.rss.dto.api.response.UserData;
import com.ultimates.rss.exception.IllegalUserException;
import com.ultimates.rss.exception.NonExistChampException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class RestTemplateService {

    private static final String uriString = "http://localhost:9090";

    private final RestTemplate restTemplate = new RestTemplate();

    public List<GameData> getRecords(String username) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/grs/gamedata/{username}")
                .queryParam("username", username)
                .encode()
                .buildAndExpand(username)
                .toUri();

        return restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<GameData>>() {
        }).getBody();
    }

    public List<GameData> getRecord(String username, int gameId) {
        URI uri = UriComponentsBuilder
                .fromUriString(uriString)
                .path("/grs/gamedata/{username}/{gameId}")
                .encode()
                .build()
                .expand(username, gameId)
                .toUri();

        return restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<GameData>>() {
        }).getBody();
    }

    public Tier getTier(String username) {
        URI uri = UriComponentsBuilder
                .fromUriString(uriString)
                .path("/grs/userdata/{username}")
                .encode()
                .build()
                .expand(username)
                .toUri();

        UserData userData = restTemplate.getForObject(uri, UserData.class);
        if (userData == null) {
            log.error("[getTier] 존재하지 않는 유저입니다.");
            throw new IllegalUserException("존재하지 않는 유저입니다.");
        }

        int tierNum = userData.getTier();
        return Arrays.stream(Tier.values()).filter(t -> t.getTierNum() == tierNum).findFirst().orElse(Tier.SILVER);
    }

    public int getChampPlayCount(String champName) {
        URI uri = UriComponentsBuilder
                .fromUriString(uriString)
                .path("/grs/gamedata/champodds/{champName}")
                .encode()
                .build()
                .expand(champName)
                .toUri();

        List<ChampData> champDataList = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<ChampData>>() {
        }).getBody();
        if (champDataList == null || champDataList.isEmpty()) {
            log.error("[getChampPlayCount] 존재하지 않는 챔프입니다.");
            throw new NonExistChampException("존재하지 않는 챔프입니다.");
        }

        return champDataList.size();
    }

    public int getChampWin(String champName) {
        URI uri = UriComponentsBuilder
                .fromUriString(uriString)
                .path("/grs/gamedata/champodds/{champName}")
                .encode()
                .build()
                .expand(champName)
                .toUri();

        List<ChampData> champDataList = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<ChampData>>() {
        }).getBody();
        if (champDataList == null || champDataList.isEmpty()) {
            log.error("[getChampWin] 존재하지 않는 챔프입니다.");
            throw new NonExistChampException("존재하지 않는 챔프입니다.");
        }

        return (int) champDataList.stream().filter(ChampData::isWin).count();
    }

    public int getChampLose(String champName) {
        URI uri = UriComponentsBuilder
                .fromUriString(uriString)
                .path("/grs/gamedata/champodds/{champName}")
                .encode()
                .build()
                .expand(champName)
                .toUri();

        List<ChampData> champDataList = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<ChampData>>() {
        }).getBody();
        if (champDataList == null || champDataList.isEmpty()) {
            log.error("[getChampLose] 존재하지 않는 챔프입니다.");
            throw new NonExistChampException("존재하지 않는 챔프입니다.");
        }

        return (int) champDataList.stream().filter(ChampData::isLose).count();
    }

    public Skill getChampSkill(String champName) {
        URI uri = UriComponentsBuilder
                .fromUriString(uriString)
                .path("/grs/champdata/{champName}")
                .encode()
                .build()
                .expand(champName)
                .toUri();

        ChampSkillData champSkillData = restTemplate.getForObject(uri, ChampSkillData.class);
        if (champSkillData == null) {
            log.error("[getChampSkill] 존재하지 않는 챔프입니다.");
            throw new NonExistChampException("존재하지 않는 챔프입니다.");
        }

        return new Skill(champSkillData.getQSkill(), champSkillData.getWSkill(), champSkillData.getESkill(), champSkillData.getRSkill());
    }

    public KDA getChampKDA(String champName) {
        URI uri = UriComponentsBuilder
                .fromUriString(uriString)
                .path("/grs/gamedata/champodds/{champName}")
                .encode()
                .build()
                .expand(champName)
                .toUri();

        List<ChampData> champDataList = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<ChampData>>() {
        }).getBody();
        if (champDataList == null || champDataList.isEmpty()) {
            log.error("[getChampKDA] 존재하지 않는 챔프입니다.");
            throw new NonExistChampException("존재하지 않는 챔프입니다.");
        }

        int kill = 0;
        int death = 0;
        int assist = 0;
        for (ChampData champData : champDataList) {
            kill += champData.getKillCnt();
            death += champData.getDeathCnt();
            assist += champData.getAssistCnt();
        }

        return new KDA(kill, death, assist);
    }

    public List<GameData> getGameDataList(String username) {
        URI uri = UriComponentsBuilder
                .fromUriString(uriString)
                .path("/grs/gamedata/{userName}")
                .encode()
                .build()
                .expand(username)
                .toUri();

        List<GameData> gameDataList = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<GameData>>() {
        }).getBody();
        if (gameDataList == null || gameDataList.isEmpty()) {
            log.error("[getGameDataList] 존재하지 않는 유저입니다.");
            throw new IllegalUserException("존재하지 않는 유저입니다.");
        }

        return gameDataList;
    }
}
