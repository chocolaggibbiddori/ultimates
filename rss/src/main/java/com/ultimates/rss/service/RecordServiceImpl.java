package com.ultimates.rss.service;

import com.ultimates.rss.GameResult;
import com.ultimates.rss.Team;
import com.ultimates.rss.dto.KDA;
import com.ultimates.rss.dto.Player;
import com.ultimates.rss.dto.RecordDetail;
import com.ultimates.rss.dto.RecordList;
import com.ultimates.rss.dto.api.response.GameData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class RecordServiceImpl implements RecordService {

    private final RestTemplateService restTemplateService;

    @Override
    public RecordDetail getRecord(String username, int gameId) {
        List<GameData> record = restTemplateService.getRecord(username, gameId);
        if (record.isEmpty()) throw new IllegalArgumentException();

        List<Player> myTeamList = record.stream()
                .filter(GameData::isWin)
                .map(gd -> Player.builder()
                        .nickname(gd.getUserName())
                        .champName(gd.getPlayChamp())
                        .tier(restTemplateService.getTier(gd.getUserName()))
                        .damage(gd.getAtkDmg())
                        .receivedDamage(gd.getRecDmg())
                        .kda(KDA.builder()
                                .kill(gd.getKillCnt())
                                .death(gd.getDeathCnt())
                                .assist(gd.getAssistCnt())
                                .build())
                        .build())
                .collect(Collectors.toList());

        List<Player> enemyTeamList = record.stream()
                .filter(GameData::isLose)
                .map(gd -> Player.builder()
                        .nickname(gd.getUserName())
                        .champName(gd.getPlayChamp())
                        .tier(restTemplateService.getTier(gd.getUserName()))
                        .damage(gd.getAtkDmg())
                        .receivedDamage(gd.getRecDmg())
                        .kda(KDA.builder()
                                .kill(gd.getKillCnt())
                                .death(gd.getDeathCnt())
                                .assist(gd.getAssistCnt())
                                .build())
                        .build())
                .collect(Collectors.toList());

        GameResult gameResult = record.stream()
                .filter(gd -> gd.getUserName().equals(username))
                .findFirst()
                .get()
                .isWin() ? GameResult.WIN : GameResult.LOSE;

        return new RecordDetail(gameId, myTeamList, enemyTeamList, gameResult, Team.BLUE);
    }

    @Override
    public List<RecordList> getRecords(String username) {
        return null;
    }
}
