package com.ultimates.rss.service;

import com.ultimates.rss.dto.Champ;
import com.ultimates.rss.dto.MostChamp;

public interface ChampService {

    Champ getChampDetail(String champName);

    MostChamp getMostChamp(String username);
}
