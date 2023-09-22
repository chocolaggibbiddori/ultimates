package com.ultimates.grs.repository;

import com.ultimates.grs.data.entity.ChampData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampRepository extends JpaRepository<ChampData,Long> {
    ChampData findByChampName(String champName);
}
