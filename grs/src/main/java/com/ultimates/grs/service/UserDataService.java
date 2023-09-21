package com.ultimates.grs.service;

import com.ultimates.grs.data.dto.GameDataDto;
import com.ultimates.grs.data.dto.UserDataDto;
import com.ultimates.grs.data.entity.GameData;
import com.ultimates.grs.data.entity.UserData;
import com.ultimates.grs.repository.GameRepository;
import com.ultimates.grs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataService {
    private final UserRepository userRepository;

    @Autowired
    public UserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<UserDataDto>> getUserDataFromDatabase() {
        List<UserData> userDataList = userRepository.findAll();
        List<UserDataDto> userDataDtoList = new ArrayList<>();

        for (UserData userData : userDataList) {
            UserDataDto userDataDto = new UserDataDto();
            userDataDto.setIdx(userData.getIdx());
            userDataDto.setGameNum(userData.getGameNum());
            userDataDto.setLv(userData.getLv());
            userDataDto.setUserName(userData.getUserName());
            userDataDto.setTier(userData.getTier());

            userDataDtoList.add(userDataDto);
        }
        return new ResponseEntity<List<UserDataDto>>(userDataDtoList, HttpStatus.OK);
    }
}