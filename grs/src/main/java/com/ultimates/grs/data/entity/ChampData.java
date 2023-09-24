package com.ultimates.grs.data.entity;

import lombok.*;


import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="champData")
public class ChampData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String champName;

    @Column(nullable = false)
    private String qSkill;

    @Column(nullable = false)
    private String wSkill;

    @Column(nullable = false)
    private String eSkill;

    @Column(nullable = false)
    private String rSkill;

    public ChampData(String champName, String qSkill, String wSkill, String eSkill, String rSkill) {
        this.champName = champName;
        this.qSkill = qSkill;
        this.wSkill = wSkill;
        this.eSkill = eSkill;
        this.rSkill = rSkill;
    }
}
