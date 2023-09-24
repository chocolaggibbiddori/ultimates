package com.ultimates.rss.dto;

import com.ultimates.rss.GameResult;
import com.ultimates.rss.Team;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class RecordDetail {

    private final int id;
    private final List<Player> myTeamList;
    private final List<Player> enemyTeamList;
    private final GameResult myResult;
    private final Team myTeam;

    public RecordDetail(int id, List<Player> myTeamList, List<Player> enemyTeamList, GameResult myResult, Team myTeam) {
        this.id = id;
        this.myTeamList = List.copyOf(myTeamList);
        this.enemyTeamList = List.copyOf(enemyTeamList);
        this.myResult = myResult;
        this.myTeam = myTeam;
    }
}
