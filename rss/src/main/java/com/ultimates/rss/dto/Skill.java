package com.ultimates.rss.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Skill {

    private final String skillQ;
    private final String skillW;
    private final String skillE;
    private final String skillR;

    @Builder
    public Skill(String skillQ, String skillW, String skillE, String skillR) {
        this.skillQ = skillQ;
        this.skillW = skillW;
        this.skillE = skillE;
        this.skillR = skillR;
    }
}
