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
    private final KDA kda;
    private final String champ;
    private final Team team;
    private final String nickname;

    @Builder
    public RecordList(Long id, LocalDateTime localDateTime, GameResult gameResult, KDA kda, String champ, Team team, String nickname) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.gameResult = gameResult;
        this.kda = kda;
        this.champ = champ;
        this.team = team;
        this.nickname = nickname;
    }
}
