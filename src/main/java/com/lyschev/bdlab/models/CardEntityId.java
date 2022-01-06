package com.lyschev.bdlab.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class CardEntityId implements Serializable {
    private static final long serialVersionUID = -8445729806340746143L;
    @Column(name = "player_id", nullable = false)
    private Integer playerId;
    @Column(name = "match_id", nullable = false)
    private Integer matchId;


    @Override
    public int hashCode() {
        return Objects.hash(matchId, playerId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CardEntityId entity = (CardEntityId) o;
        return Objects.equals(this.matchId, entity.matchId) &&
                Objects.equals(this.playerId, entity.playerId);
    }
}