package com.ultimates.grs.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "gameData")
public class GameData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto_increment 자동 증가
    private Long idx;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private int gameNumber;

    @Column(nullable = false)
    private LocalDateTime startTime;
  
    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private String playChamp;

    @Column(nullable = false)
    private int killCnt;

    @Column(nullable = false)
    private int deathCnt;

    @Column(nullable = false)
    private int assistCnt;

    @Column(nullable = false)
    private boolean win;

    @Column(nullable = false)
    private int atkDmg;

    @Column(nullable = false)
    private int recDmg;
}
