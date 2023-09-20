package com.ultimates.rss.controller;

import com.ultimates.rss.dto.Champ;
import com.ultimates.rss.dto.MostChamp;
import com.ultimates.rss.dto.Record;
import com.ultimates.rss.dto.RecordList;
import com.ultimates.rss.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RequestMapping("/rss")
@Controller
public class SearchController {

    private final RecordService recordService;

    @Autowired
    public SearchController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/{name}")
    public String search(@PathVariable String name,
                         @RequestParam(required = false, defaultValue = "nickname") String condition, Model model) {
        log.info("[search] name = {}, condition = {}", name, condition);
        SearchCondition searchCondition = SearchCondition.valueOf(condition.toUpperCase());
        return searchCondition.search(this, name, model);
    }

    @GetMapping("/{name}/{gameId}")
    public String record(@PathVariable String name, @PathVariable String gameId, Model model) {
        log.info("[record] name = {}, gameId = {}", name, gameId);
        Record record = recordService.getRecord(name, gameId);
        model.addAttribute("record", record);
        return "record";
    }

    private String searchRecords(String username, Model model) {
        List<RecordList> recordList = recordService.getRecords(username);
        MostChamp mostChamp = recordService.getMostChamp(username);

        model.addAttribute("recordList", recordList);
        model.addAttribute("mostChamp", mostChamp);
        return "records";
    }

    private String searchChamp(String champName, Model model) {
        Champ champ = recordService.getChampDetail(champName);
        model.addAttribute("champ", champ);
        return "champ";
    }

    private enum SearchCondition {

        CHAMPION {
            @Override
            String search(SearchController controller, String name, Model model) {
                return controller.searchRecords(name, model);
            }
        }, NICKNAME {
            @Override
            String search(SearchController controller, String name, Model model) {
                return controller.searchChamp(name, model);
            }
        };

        abstract String search(SearchController controller, String name, Model model);
    }
}
