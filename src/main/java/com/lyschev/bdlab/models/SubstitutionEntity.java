package com.lyschev.bdlab.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "substitution")
@Entity
@Getter
@Setter
public class SubstitutionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "teams_main")
    private TeamMainEntity teamsMain;

    @ManyToOne
    @JoinColumn(name = "teams_sub")
    private TeamSubEntity teamsSub;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private MatchEntity match;

}