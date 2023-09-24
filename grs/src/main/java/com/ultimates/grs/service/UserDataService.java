package com.ultimates.grs.service;

import com.ultimates.grs.data.dto.UserDataDto;
import com.ultimates.grs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {

    private final UserRepository userRepository;

    @Autowired
    public UserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<UserDataDto>> getUserDataFromDatabase() {
        List<UserDataDto> userDataDtoList = userRepository.findUserDataDtoList();
        return new ResponseEntity<>(userDataDtoList, HttpStatus.OK);
    }

    public ResponseEntity<UserDataDto> getUserDataFromDatabase(String userName) {
        UserDataDto userDataDto = userRepository.findByUserName(userName);
        return new ResponseEntity<>(userDataDto, HttpStatus.OK);
    }
}
