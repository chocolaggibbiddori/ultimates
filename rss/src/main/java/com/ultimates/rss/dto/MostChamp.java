package com.ultimates.rss.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MostChamp {

    private final String champName;
    private final int kill;
    private final int death;
    private final int assist;
    private final double rateOfWin;
    private final int playCount;

    @Builder
    public MostChamp(String champName, int kill, int death, int assist, double rateOfWin, int playCount) {
        this.champName = champName;
        this.kill = kill;
        this.death = death;
        this.assist = assist;
        this.rateOfWin = rateOfWin;
        this.playCount = playCount;
    }
}
