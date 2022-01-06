package com.lyschev.bdlab.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "leagues")
@Entity
@Getter
@Setter
public class LeagueEntity {
    @Id
    @Column(name = "league_name", nullable = false, length = 32)
    private String name;

    @Column(name = "num_teams", nullable = false)
    private Integer num_teams;

    @Column(name = "prize", nullable = false)
    private Integer prize;

}