package com.lyschev.bdlab.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "teams_sub")
@Entity
@Getter
@Setter
public class TeamSubEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private ClubEntity teamId;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity player;


}