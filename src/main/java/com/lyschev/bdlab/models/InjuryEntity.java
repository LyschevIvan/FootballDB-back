package com.lyschev.bdlab.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "injuries")
@Entity
@Getter
@Setter
public class InjuryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "injury_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private MatchEntity match;

    @Column(name = "description", nullable = false, length = 64)
    private String description;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "coefficient", nullable = false)
    private Double coefficient;

}