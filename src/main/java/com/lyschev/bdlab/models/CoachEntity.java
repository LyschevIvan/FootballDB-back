package com.lyschev.bdlab.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "coaches")
@Entity
@Setter
@Getter
public class CoachEntity {
    @Id
    @Column(name = "coach_name", nullable = false, length = 32)
    private String name;

    @Column(name = "seasons_in_club")
    private Integer seasonsInClub;

    @Column(name = "money_spent")
    private Integer moneySpent;

    @Column(name = "titles_won", nullable = false)
    private Integer titlesWon;


}