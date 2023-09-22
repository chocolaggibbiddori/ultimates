package com.ultimates.grs.controller;

import com.ultimates.grs.data.dto.GameDataDto;
import com.ultimates.grs.data.dto.UserDataDto;
import com.ultimates.grs.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/userdata")
    public ResponseEntity<List<UserDataDto>> getUserData() {

        ResponseEntity<List<UserDataDto>> responseEntity = userDataService.getUserDataFromDatabase();
        return responseEntity;
    }
}