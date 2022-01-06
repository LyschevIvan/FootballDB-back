package com.lyschev.bdlab.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "teams_main")
@Entity
@Getter
@Setter
public class TeamMainEntity implements EntityInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    public TeamMainEntity() {
    }

}