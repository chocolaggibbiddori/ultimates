package com.ultimates.grs.repository;

import com.ultimates.grs.data.entity.GameData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<GameData,Long> {
    List<GameData> findByPlayChamp(String champName);
}
