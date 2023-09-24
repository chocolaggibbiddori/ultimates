package com.ultimates.grs.repository;

import com.ultimates.grs.data.dto.ChampOddsDto;
import com.ultimates.grs.data.dto.GameDataDto;
import com.ultimates.grs.data.entity.GameData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<GameData, Long> {

    @Query("SELECT new com.ultimates.grs.data.dto.GameDataDto(gd) FROM GameData gd")
    List<GameDataDto> findGameDataDtoList();
    @Query("SELECT new com.ultimates.grs.data.dto.GameDataDto(gd) FROM GameData gd WHERE userName = ?1")
    List<GameDataDto> findByUserName(String userName);
    @Query("SELECT new com.ultimates.grs.data.dto.GameDataDto(gd) FROM GameData gd WHERE gameNumber = ?1")
    List<GameDataDto> findByGameNumber(Integer gameNumber);
    @Query("SELECT new com.ultimates.grs.data.dto.ChampOddsDto(gd) FROM GameData gd WHERE playChamp = ?1")
    List<ChampOddsDto> findChampOddsDtoListByPlayChamp(String champName);
}
