package com.ultimates.rss.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Champ {

    private final int playCount;
    private final int win;
    private final int lose;
    private final double rateOfWin;

    @Builder
    public Champ(int playCount, int win, int lose, double rateOfWin) {
        this.playCount = playCount;
        this.win = win;
        this.lose = lose;
        this.rateOfWin = rateOfWin;
    }
}
