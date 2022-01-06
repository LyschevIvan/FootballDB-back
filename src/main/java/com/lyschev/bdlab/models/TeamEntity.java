package com.lyschev.bdlab.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Table(name = "teams")
@Entity
@Setter
@Getter
public class TeamEntity implements EntityInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teams_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "club_name")
    private ClubEntity club;

    @Column(name = "captain", nullable = false)
    private Integer captain;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private Set<TeamMainEntity> teamsMainEntities;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(table = "teams_sub", name = "id")
//    private Set<TeamsSubEntity> teamsSubEntities;

}