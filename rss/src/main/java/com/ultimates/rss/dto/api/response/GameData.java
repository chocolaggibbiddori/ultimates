package com.ultimates.rss.dto.api.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GameData {

    private Long idx;
    private String userName;
    private int gameNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String playChamp;
    private int killCnt;
    private int deathCnt;
    private int assistCnt;
    private boolean win;
    private int atkDmg;
    private int recDmg;

    public boolean isLose() {
        return !isWin();
    }
}
