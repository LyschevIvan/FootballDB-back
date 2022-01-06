package com.lyschev.bdlab.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "players")
@Entity
@Getter
@Setter
public class PlayerEntity implements EntityInterface{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "club")
    private ClubEntity club;

    @Column(name = "player_name", nullable = false, length = 32)
    private String playerName;

    @Column(name = "player_surname", nullable = false, length = 32)
    private String playerSurname;

    @Column(name = "nationality", nullable = false, length = 32)
    private String nationality;

    @Column(name = "pace", nullable = false)
    private Integer pace;

    @Column(name = "shooting", nullable = false)
    private Integer shooting;

    @Column(name = "pass", nullable = false)
    private Integer pass;

    @Column(name = "dribbling", nullable = false)
    private Integer dribbling;

    @Column(name = "defending", nullable = false)
    private Integer defending;

    @Column(name = "physicality", nullable = false)
    private Integer physicality;

    @Column(name = "price", nullable = false, length = 32)
    private String price;

    @Override
    public String toString() {
        return "PlayerEntity{" +
                "id=" + id +
                ", club=" + club +
                ", playerName='" + playerName + '\'' +
                ", playerSurname='" + playerSurname + '\'' +
                ", nationality='" + nationality + '\'' +
                ", pace=" + pace +
                ", shooting=" + shooting +
                ", pass=" + pass +
                ", dribbling=" + dribbling +
                ", defending=" + defending +
                ", physicality=" + physicality +
                ", price='" + price + '\'' +
                '}';
    }
}