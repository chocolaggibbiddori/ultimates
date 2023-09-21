package com.ultimates.rss.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class RecordDetail {

    private final Long id;
    private final List<Player> winnerList;
    private final List<Player> loserList;

    public RecordDetail(Long id, List<Player> winnerList, List<Player> loserList) {
        this.id = id;
        this.winnerList = winnerList;
        this.loserList = loserList;
    }
}
