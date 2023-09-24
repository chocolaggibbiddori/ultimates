package com.ultimates.grs.repository;

import com.ultimates.grs.data.dto.ChampDataDto;
import com.ultimates.grs.data.entity.ChampData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChampRepository extends JpaRepository<ChampData, Long> {

    @Query("SELECT new com.ultimates.grs.data.dto.ChampDataDto(cd.idx, cd.champName, cd.qSkill, cd.wSkill, cd.eSkill, cd.rSkill) FROM ChampData cd")
    List<ChampDataDto> findChampDataDtoList();
    @Query("SELECT new com.ultimates.grs.data.dto.ChampDataDto(cd.idx, cd.champName, cd.qSkill, cd.wSkill, cd.eSkill, cd.rSkill) FROM ChampData cd WHERE champName = ?1")
    ChampDataDto findByChampName(String champName);
}
