package com.lyschev.bdlab.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "owners")
@Entity
@Getter
@Setter
public class OwnerEntity {
    @Id
    @Column(name = "owner_name", nullable = false, length = 32)
    private String name;

    @Column(name = "wealth")
    private Integer wealth;

    @Column(name = "nationality", length = 32)
    private String nationality;


}