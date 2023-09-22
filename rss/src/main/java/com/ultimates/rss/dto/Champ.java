package com.ultimates.rss.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Champ {

    private final String champName;
    private final int playCount;
    private final int win;
    private final int lose;
    private final double rateOfWin;
    private final Skill skill;
    private final KDA kda;

    @Builder
    public Champ(String champName, int playCount, int win, int lose, double rateOfWin, Skill skill, KDA kda) {
        this.champName = champName;
        this.playCount = playCount;
        this.win = win;
        this.lose = lose;
        this.rateOfWin = rateOfWin;
        this.skill = skill;
        this.kda = kda;
    }
}
