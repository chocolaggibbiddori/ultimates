package com.ultimates.grs.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
public class GameDataDto {
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

}
