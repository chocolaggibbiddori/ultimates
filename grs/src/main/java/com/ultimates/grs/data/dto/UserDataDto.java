package com.ultimates.grs.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDataDto {
    private Long idx;
    private int gameNum;
    private int lv;
    private String userName;
    private int tier;

}
