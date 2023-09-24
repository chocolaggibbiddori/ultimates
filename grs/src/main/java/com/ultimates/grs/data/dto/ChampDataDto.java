package com.ultimates.grs.data.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChampDataDto {

    private Long idx;
    private String champName;
    private String qSkill;
    private String wSkill;
    private String eSkill;
    private String rSkill;

    public ChampDataDto(Long idx, String champName, String qSkill, String wSkill, String eSkill, String rSkill) {
        this.idx = idx;
        this.champName = champName;
        this.qSkill = qSkill;
        this.wSkill = wSkill;
        this.eSkill = eSkill;
        this.rSkill = rSkill;
    }
}
