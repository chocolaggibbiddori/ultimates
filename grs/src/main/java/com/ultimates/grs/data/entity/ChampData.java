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
    
}
