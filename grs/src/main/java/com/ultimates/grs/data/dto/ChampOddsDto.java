package com.ultimates.grs.data.dto;

import com.ultimates.grs.data.entity.GameData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ChampOddsDto {

    private String playChamp;
    private int killCnt;
    private int deathCnt;
    private int assistCnt;
    private boolean win;

    public ChampOddsDto(GameData gd) {
        this.playChamp = gd.getPlayChamp();
        this.killCnt = gd.getKillCnt();
        this.deathCnt = gd.getDeathCnt();
        this.assistCnt = gd.getAssistCnt();
        this.win = gd.isWin();
    }
}
