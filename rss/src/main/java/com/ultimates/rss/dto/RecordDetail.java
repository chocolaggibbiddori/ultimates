package com.ultimates.rss.dto;

import com.ultimates.rss.GameResult;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class RecordDetail {

    private final Long id;
    private final List<Player> myTeamList;
    private final List<Player> enemyTeamList;
    private final GameResult myResult;

    public RecordDetail(Long id, List<Player> myTeamList, List<Player> enemyTeamList, GameResult myResult) {
        this.id = id;
        this.myTeamList = List.copyOf(myTeamList);
        this.enemyTeamList = List.copyOf(enemyTeamList);
        this.myResult = myResult;
    }
}
