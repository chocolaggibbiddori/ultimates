package com.ultimates.grs.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "userData")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private int gameNum;

    @Column(nullable = false)
    private int lv;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private Integer tier;
}
