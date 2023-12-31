package com.ultimates.rss.controller;

import com.ultimates.rss.dto.Champ;
import com.ultimates.rss.dto.MostChamp;
import com.ultimates.rss.dto.RecordDetail;
import com.ultimates.rss.dto.RecordList;
import com.ultimates.rss.service.ChampService;
import com.ultimates.rss.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@RequestMapping("/rss")
@Controller
public class SearchController {

    private final RecordService recordService;
    private final ChampService champService;

    @Autowired
    public SearchController(RecordService recordService, ChampService champService) {
        this.recordService = recordService;
        this.champService = champService;
    }

    @GetMapping
    public String search() {
        return "search";
    }

    @PostMapping
    public String search(@RequestParam String name, @RequestParam String condition, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name", name);
        return "redirect:/rss/{name}?condition=" + condition;
    }

    @GetMapping("/{name}")
    public String search(@PathVariable String name,
                         @RequestParam(required = false, defaultValue = "nickname") String condition, Model model) {
        log.info("[search] name = {}, condition = {}", name, condition);
        SearchCondition searchCondition = SearchCondition.valueOf(condition.toUpperCase());
        return searchCondition.search(this, name, model);
    }

    @GetMapping("/{username}/{recordId}")
    public String recordDetail(@PathVariable String username, @PathVariable int recordId, Model model) {
        log.info("[record] username = {}, recordId = {}", username, recordId);

        RecordDetail recordDetail = recordService.getRecord(username, recordId);

        model.addAttribute("recordDetail", recordDetail);
        return "recordDetail";
    }

    private String searchRecords(String username, Model model) {
        List<RecordList> recordList = recordService.getRecords(username);
        List<MostChamp> mostChampList = champService.getMostChampList(username);

        model.addAttribute("username", username);
        model.addAttribute("recordList", recordList);
        model.addAttribute("mostChampList", mostChampList);
        return "records";
    }

    private String searchChamp(String champName, Model model) {
        Champ champ = champService.getChampDetail(champName);

        model.addAttribute("champ", champ);
        return "champ";
    }

    private enum SearchCondition {

        NICKNAME {
            @Override
            String search(SearchController controller, String name, Model model) {
                return controller.searchRecords(name, model);
            }
        }, CHAMPION {
            @Override
            String search(SearchController controller, String name, Model model) {
                return controller.searchChamp(name, model);
            }
        };

        abstract String search(SearchController controller, String name, Model model);
    }
}
