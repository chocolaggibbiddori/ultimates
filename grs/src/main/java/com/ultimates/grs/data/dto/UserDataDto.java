package com.ultimates.grs.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDataDto {

    private Long idx;
    private int gameNum;
    private int lv;
    private String userName;
    private int tier;

    public UserDataDto(Long idx, int gameNum, int lv, String userName, int tier) {
        this.idx = idx;
        this.gameNum = gameNum;
        this.lv = lv;
        this.userName = userName;
        this.tier = tier;
    }
}
