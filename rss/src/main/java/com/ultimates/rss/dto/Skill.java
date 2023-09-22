package com.ultimates.rss.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Skill {

    private final String skill1;
    private final String skill2;
    private final String skill3;
    private final String skill4;

    @Builder
    public Skill(String skill1, String skill2, String skill3, String skill4) {
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.skill4 = skill4;
    }
}
