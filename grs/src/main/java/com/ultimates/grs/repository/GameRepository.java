package com.ultimates.grs.repository;

import com.ultimates.grs.data.entity.GameData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameData,Long> {
}
