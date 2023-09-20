package com.ultimates.rss.service;

import com.ultimates.rss.dto.Record;
import com.ultimates.rss.dto.RecordList;

import java.util.List;

public interface RecordService {

    /**
     * 해당 유저가 플레이 한 게임에 대한 정보를 반환하는 메서드
     * @param username 유저의 닉네임
     * @param gameId 게임 인덱스
     * @return 게임 정보를 포함하는 Record 객체
     * @author chocolaggibbiddori
     */
    Record getRecord(String username, int gameId);

    /**
     * 해당 유저의 전체 게임 리스트를 반환하는 메서드
     * @param username 유저의 닉네임
     * @return 유저의 모든 게임 리스트를 {@code List}에 담아서 반환
     * @author chocolaggibbiddori
     */
    List<RecordList> getRecords(String username);
}
