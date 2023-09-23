package com.ultimates.grs.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ChampOddsDto {

    private String playChamp;
    private int killCnt;
    private int deathCnt;
    private int assistCnt;
    private boolean win;

}
