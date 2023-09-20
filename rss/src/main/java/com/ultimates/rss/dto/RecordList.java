package com.ultimates.rss.dto;

import com.ultimates.rss.GameResult;
import com.ultimates.rss.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class RecordList {

    private final Long id;
    private final LocalDateTime localDateTime;
    private final GameResult gameResult;
    private final int kill;
    private final int death;
    private final int assist;
    private final String champ;
    private final Team team;
    private final String nickname;

    @Builder
    public RecordList(Long id, LocalDateTime localDateTime, GameResult gameResult, int kill, int death, int assist, String champ, Team team, String nickname) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.gameResult = gameResult;
        this.kill = kill;
        this.death = death;
        this.assist = assist;
        this.champ = champ;
        this.team = team;
        this.nickname = nickname;
    }
}
