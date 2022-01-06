package com.lyschev.bdlab.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Table(name = "clubs")
@Entity
@Getter
@Setter
public class ClubEntity implements EntityInterface {
    @Id
    @Column(name = "club_name", nullable = false, length = 32)
    private String name;

    @ManyToOne
    @JoinColumn(name = "coach_name")
    private CoachEntity coachName;

    @ManyToOne
    @JoinColumn(name = "owner_name")
    private OwnerEntity ownerName;

    @ManyToOne
    @JoinColumn(name = "league_name")
    private LeagueEntity leagueName;

    @Column(name = "country", nullable = false, length = 32)
    private String country;

    @Column(name = "city", nullable = false, length = 32)
    private String city;

    @Column(name = "last_pos", nullable = false)
    private Integer lastPos;

    @Column(name = "recent_score", nullable = false)
    private Integer recentScore;

    @OneToMany(mappedBy = "club")
    private Set<PlayerEntity> players;

    @Override
    public String toString() {
        return "ClubEntity{" +
                "name='" + name + '\'' +
                ", coachName=" + coachName +
                ", ownerName=" + ownerName +
                ", leagueName=" + leagueName +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", lastPos=" + lastPos +
                ", recentScore=" + recentScore +
                '}';
    }
}