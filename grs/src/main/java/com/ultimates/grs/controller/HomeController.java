package com.ultimates.grs.controller;

import com.ultimates.grs.service.GameDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class HomeController {

    private final GameDataService gameService;

    @Autowired
    public HomeController(GameDataService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<String> test(){

        return null;
    }
}
