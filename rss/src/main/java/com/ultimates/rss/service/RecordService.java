package com.ultimates.rss.service;

import com.ultimates.rss.dto.Champ;
import com.ultimates.rss.dto.MostChamp;
import com.ultimates.rss.dto.RecordDetail;
import com.ultimates.rss.dto.RecordList;

import java.util.List;

public interface
RecordService {

    RecordDetail getRecord(String username, int recordId);

    List<RecordList> getRecords(String username);

    Champ getChampDetail(String champName);

    List<MostChamp> getMostChamp(String username);
}
