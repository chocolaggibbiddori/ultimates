package com.ultimates.rss.service;

import com.ultimates.rss.dto.Champ;
import com.ultimates.rss.dto.MostChamp;
import com.ultimates.rss.dto.Record;
import com.ultimates.rss.dto.RecordList;

import java.util.List;

public interface RecordService {

    Record getRecord(String username, int gameId);

    List<RecordList> getRecords(String username);

    Champ getChampDetail(String champName);

    MostChamp getMostChamp(String username);
}
