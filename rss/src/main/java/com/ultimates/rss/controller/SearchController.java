package com.ultimates.rss.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/rss")
public class SearchController {
    @GetMapping
    public String search() {
        return "search";
    }

    @PostMapping
    public String searchActivity(@RequestParam String condition, @RequestParam String name) {
        return "redirect:/rss/"+name+"?condition="+condition;
    }

    @GetMapping("/{name}")
    public String records(@PathVariable String name, @RequestParam String condition) {
        log.info("==>records()");
        //model.addAttribute("name",name);
        return "records";
    }

}
