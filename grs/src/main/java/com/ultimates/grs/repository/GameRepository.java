package com.ultimates.grs.repository;


import com.ultimates.grs.data.dto.GameDataDto;
import com.ultimates.grs.data.dto.UserDataDto;
import com.ultimates.grs.data.dto.ChampOddsDto;
import com.ultimates.grs.data.entity.GameData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface GameRepository extends JpaRepository<GameData,Long> {
    List<GameData> findByUserName(String userName);

    List<GameData> findByUserNameAndGameNumber(String userName,Integer gameNumber);
    List<GameData> findByGameNumber(Integer gameNumber);

    List<GameData> findByPlayChamp(String champName);


}
