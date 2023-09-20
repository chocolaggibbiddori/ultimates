package com.ultimates.rss.service;

import com.ultimates.rss.dto.Champ;
import com.ultimates.rss.dto.MostChamp;
import com.ultimates.rss.exception.IllegalUserException;
import com.ultimates.rss.exception.NonExistChampException;

public interface ChampService {

    /**
     * 해당 챔프의 상세 정보를 반환하는 메서드
     * @param champName 챔프의 이름
     * @return 챔프의 상세 정보를 담고 있는 Champ 객체
     * @throws NonExistChampException {@code champName}에 해당하는 챔프가 존재하지 않으면 이 예외가 발생
     * @author chocolaggibbiddori
     */
    Champ getChampDetail(String champName);

    /**
     * 해당 유저의 모스트 챔프 정보를 반환하는 메서드
     * @param username 유저의 닉네임
     * @return 유저의 모스트 챔프 정보를 담고 있는 MostChamp 객체
     * @throws IllegalUserException {@code username}이 존재하지 않는 유저라면 이 예외가 발생
     * @author chocolaggibbiddori
     */
    MostChamp getMostChamp(String username);
}
