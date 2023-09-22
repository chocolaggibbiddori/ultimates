package com.ultimates.grs.repository;

import com.ultimates.grs.data.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData,Long> {
}
