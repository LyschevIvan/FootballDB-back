package com.lyschev.bdlab.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "cards")
@Entity
@Getter
@Setter
public class CardEntity {
    @EmbeddedId
    private CardEntityId id;

    @Column(name = "amount_yellow", nullable = false)
    private Integer amountYellow;

    @Column(name = "skips", nullable = false)
    private Integer skips;

    @Column(name = "reason", nullable = false, length = 64)
    private String reason;

   
}