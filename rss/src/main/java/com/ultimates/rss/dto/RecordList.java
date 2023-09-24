package com.ultimates.rss.dto;

import com.ultimates.rss.GameResult;
import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@ToString
public class RecordList {

    private final int id;
    private final Long playHourTime;
    private final Long playMinuteTime;
    private final GameResult gameResult;
    private final KDA kda;
    private final String champ;
    private final String nickname;

    @Builder
    public RecordList(int id, LocalDateTime startTime, LocalDateTime endTime, GameResult gameResult, KDA kda, String champ, String nickname) {
        this.id = id;
        this.playHourTime = playHourTime(startTime,endTime);
        this.playMinuteTime = playMinuteTime(startTime,endTime);
        this.gameResult = gameResult;
        this.kda = kda;
        this.champ = champ;
        this.nickname = nickname;
    }

    private Long playHourTime(LocalDateTime startTime, LocalDateTime endTime) {
        Duration playTime = Duration.between(startTime, endTime);

        long playHour = playTime.toHours();

        return playHour;
    }

    private Long playMinuteTime(LocalDateTime startTime, LocalDateTime endTime) {
        Duration playTime = Duration.between(startTime, endTime);

        long playMinute = playTime.toMinutesPart();

        return playMinute;
    }
}
