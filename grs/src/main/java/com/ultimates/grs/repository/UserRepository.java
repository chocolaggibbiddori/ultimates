package com.ultimates.grs.repository;

import com.ultimates.grs.data.dto.UserDataDto;
import com.ultimates.grs.data.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserData,Long> {

    UserData findByUserName(String userName);
}
