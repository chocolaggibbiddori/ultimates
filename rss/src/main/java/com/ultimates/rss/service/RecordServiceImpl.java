package com.ultimates.rss.service;

import com.ultimates.rss.GameResult;
import com.ultimates.rss.dto.KDA;
import com.ultimates.rss.dto.RecordDetail;
import com.ultimates.rss.dto.RecordList;
import com.ultimates.rss.dto.api.response.GameData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RecordServiceImpl implements RecordService {
    private final RestTemplateService restTemplateService;

    @Autowired
    public RecordServiceImpl(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @Override
    public RecordDetail getRecord(String username, int recordId) {
        return null;
    }

    @Override
    public List<RecordList> getRecords(String username) {
        List<GameData> recordListsData = restTemplateService.getRecords(username);
        List<RecordList> recordList = new ArrayList<>();
        log.info("[getRecords] recordListsData = {}", recordListsData);
        for (GameData recordListsDatum : recordListsData) {
            KDA kda = new KDA(recordListsDatum.getKillCnt(),
                    recordListsDatum.getDeathCnt(),
                    recordListsDatum.getAssistCnt());

            RecordList recordListDto = new RecordList(recordListsDatum.getGameNumber(),
                    recordListsDatum.getStartTime(),
                    recordListsDatum.getEndTime(),
                    recordListsDatum.isWin() ? GameResult.WIN : GameResult.LOSE,
                    kda,
                    recordListsDatum.getPlayChamp(),
                    username);

            recordList.add(recordListDto);
        }
        return recordList;
    }
}
