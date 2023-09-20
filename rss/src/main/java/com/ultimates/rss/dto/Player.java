package com.ultimates.rss.dto;

import com.ultimates.rss.Tier;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Player {

    private final String nickname;
    private final int damage;
    private final int receivedDamage;
    private final Tier tier;
    private final int kill;
    private final int death;
    private final int assist;

    @Builder
    public Player(String nickname, int damage, int receivedDamage, Tier tier, int kill, int death, int assist) {
        this.nickname = nickname;
        this.damage = damage;
        this.receivedDamage = receivedDamage;
        this.tier = tier;
        this.kill = kill;
        this.death = death;
        this.assist = assist;
    }
}
