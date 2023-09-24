package com.ultimates.grs.controller;

import com.ultimates.grs.data.dto.GameDataDto;
import com.ultimates.grs.data.dto.UserDataDto;
import com.ultimates.grs.data.entity.UserData;
import com.ultimates.grs.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grs")
public class UserController {

    private final UserDataService userDataService;

    @Autowired
    public UserController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    // 모든 유저에 대한 정보 리스트
    @GetMapping("/userdata")
    public ResponseEntity<List<UserDataDto>> getUserData() {

        ResponseEntity<List<UserDataDto>> responseEntity = userDataService.getUserDataFromDatabase();
        return responseEntity;
    }

    // 검색한 유저가 했던 게임 정보들
    @GetMapping("/userdata/{userName}")
    public ResponseEntity<List<UserDataDto>> getUserSearchData(@PathVariable("userName") String userName) {
        ResponseEntity<List<UserDataDto>> responseEntity = userDataService.getUserLvFromDatabase(userName);

        return responseEntity;
    }
}