package com.ultimates.rss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping(value = "/")
    public String index() {
        return "redirect:/rss";
    }

}