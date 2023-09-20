package com.ultimates.rss.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Record {

    private final Long id;
    private final List<Player> playerList;

    public Record(Long id, Player... players) {
        this.id = id;
        this.playerList = List.of(players);
    }
}
