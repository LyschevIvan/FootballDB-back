package com.lyschev.bdlab.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Table(name = "matches")
@Entity
@Setter
@Getter
public class MatchEntity implements EntityInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "team1_id")
    private TeamEntity team1;

    @ManyToOne
    @JoinColumn(name = "team2_id")
    private TeamEntity team2;

    @ManyToOne
    @JoinColumn(name = "league")
    private LeagueEntity league;

    @Column(name = "score", nullable = false)
    private Integer score;

    @Column(name = "tour", nullable = false)
    private Integer tour;

    @Column(name = "\"time\"")
    private OffsetDateTime time;

    
}