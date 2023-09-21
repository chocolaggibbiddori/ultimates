package com.ultimates.rss.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MostChamp {

    private final String champName;
    private final KDA kda;
    private final double rateOfWin;
    private final int playCount;

    @Builder
    public MostChamp(String champName, KDA kda, double rateOfWin, int playCount) {
        this.champName = champName;
        this.kda = kda;
        this.rateOfWin = rateOfWin;
        this.playCount = playCount;
    }
}
