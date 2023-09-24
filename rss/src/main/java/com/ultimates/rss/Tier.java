package com.ultimates.rss;

import lombok.Getter;

@Getter
public enum Tier {

    BRONZE(5), SILVER(4), GOLD(3), PLATINUM(2), DIAMOND(1);

    private final int tierNum;

    Tier(int tierNum) {
        this.tierNum = tierNum;
    }
}
