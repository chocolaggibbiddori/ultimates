package com.ultimates.rss.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MostChamp {

    private String champName;
    private KDA kda;
    private int kill;
    private int death;
    private int assist;
    private double rateOfWin;
    private int playCount;
    private int winCount;

    public MostChamp(String champName) {
        this.champName = champName;
    }

    public void addPlayCount() {
        playCount++;
    }

    public void addWinCount() {
        winCount++;
    }

    public double getRateOfWin() {
        return (double) winCount / playCount * 100;
    }

    public void addKill(int kill) {
        this.kill += kill;
    }

    public void addDeath(int death) {
        this.death += death;
    }

    public void addAssist(int assist) {
        this.assist += assist;
    }

    public KDA getKda() {
        return new KDA(kill, death, assist);
    }
}
