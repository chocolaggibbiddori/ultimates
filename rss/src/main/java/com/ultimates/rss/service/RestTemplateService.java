package com.ultimates.rss.service;

import com.ultimates.rss.Tier;
import com.ultimates.rss.dto.api.response.UserData;
import com.ultimates.rss.dto.api.response.GameData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class RestTemplateService {

    private static final String uriString = "http://localhost:9090";

    public List<GameData> getRecord(String username, int gameId) {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder
                .fromUriString(uriString)
                .path("/grs/gamedata/{username}/{gameId}")
                .encode()
                .build()
                .expand(username, gameId)
                .toUri();

        return restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<GameData>>() {
        }).getBody();
    }

    public Tier getTier(String username) {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder
                .fromUriString(uriString)
                .path("/grs/userdata/{username}")
                .encode()
                .build()
                .expand(username)
                .toUri();

        UserData userData = restTemplate.getForObject(uri, UserData.class);
        Objects.requireNonNull(userData);

        int tierNum = userData.getTier();
        return Arrays.stream(Tier.values()).filter(t -> t.getTierNum() == tierNum).findFirst().orElse(Tier.SILVER);
    }
}
