package com.ultimates.rss.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class KDA {

    private final int kill;
    private final int death;
    private final int assist;
    private final String rate;

    @Builder
    public KDA(int kill, int death, int assist) {
        this.kill = kill;
        this.death = death;
        this.assist = assist;
        this.rate = calRate();
    }

    private String calRate() {
        return death == 0 ? "PERFECT" : String.valueOf((double) (kill + assist) / death);
    }

    @Override
    public String toString() {
        return kill + "/" + death + "/" + assist;
    }
}
