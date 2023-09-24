package com.ultimates.grs.data.dto;

import com.ultimates.grs.data.entity.GameData;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
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

    public GameDataDto(GameData gd) {
        this.idx = gd.getIdx();
        this.userName = gd.getUserName();
        this.gameNumber = gd.getGameNumber();
        this.startTime = gd.getStartTime();
        this.endTime = gd.getEndTime();
        this.playChamp = gd.getPlayChamp();
        this.killCnt = gd.getKillCnt();
        this.deathCnt = gd.getDeathCnt();
        this.assistCnt = gd.getAssistCnt();
        this.win = gd.isWin();
        this.atkDmg = gd.getAtkDmg();
        this.recDmg = gd.getRecDmg();
    }
}
