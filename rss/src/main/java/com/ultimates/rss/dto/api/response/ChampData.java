package com.ultimates.rss.dto.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChampData {

    private String playChamp;
    private int killCnt;
    private int deathCnt;
    private int assistCnt;
    private boolean win;

    public boolean isLose() {
        return !isWin();
    }
}
