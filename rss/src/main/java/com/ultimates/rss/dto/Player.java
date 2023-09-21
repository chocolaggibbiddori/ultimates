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
    private final KDA kda;

    @Builder
    public Player(String nickname, int damage, int receivedDamage, Tier tier, KDA kda) {
        this.nickname = nickname;
        this.damage = damage;
        this.receivedDamage = receivedDamage;
        this.tier = tier;
        this.kda = kda;
    }
}
