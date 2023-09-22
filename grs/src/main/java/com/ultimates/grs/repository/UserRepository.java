package com.ultimates.grs.repository;

import com.ultimates.grs.data.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository  extends JpaRepository<UserData,Long> {
    List<UserData> findByUserName(String userName);
    @Query(value = "select ud from UserData ud where ud.userName> ?1")
    public List<UserData> selectByUsername(String userName);



}
