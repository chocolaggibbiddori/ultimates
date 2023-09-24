package com.ultimates.grs.repository;

import com.ultimates.grs.data.dto.UserDataDto;
import com.ultimates.grs.data.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserData, Long> {

    @Query("SELECT new com.ultimates.grs.data.dto.UserDataDto(ud.idx, ud.gameNum, ud.lv, ud.userName, ud.tier) FROM UserData ud")
    List<UserDataDto> findUserDataDtoList();
    @Query("SELECT new com.ultimates.grs.data.dto.UserDataDto(ud.idx, ud.gameNum, ud.lv, ud.userName, ud.tier) FROM UserData ud WHERE userName = ?1")
    UserDataDto findByUserName(String userName);
}
