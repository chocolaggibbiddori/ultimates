package com.ultimates.rss.service;

import com.ultimates.rss.dto.RecordDetail;
import com.ultimates.rss.dto.api.response.GameData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@Service
public class RestTemplateService {

    public RecordDetail getRecord(String username, int recordId) {
        return null;
    }

    public List<GameData> getRecords(String username) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/grs/gamedata/{username}")
                .queryParam("username", username)
                .encode()
                .buildAndExpand(username)
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<GameData>>() {}).getBody();
    }
}
