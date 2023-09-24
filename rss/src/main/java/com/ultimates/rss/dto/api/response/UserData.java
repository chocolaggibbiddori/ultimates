package com.ultimates.rss.dto.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData {

    private Long idx;
    private int gameNum;
    private int lv;
    private String userName;
    private int tier;
}
