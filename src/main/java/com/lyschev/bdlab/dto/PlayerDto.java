package com.lyschev.bdlab.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PlayerDto implements Serializable, Dto {
    private Integer id;

    private String clubName;

    private String playerName;

    private String playerSurname;

    private String nationality;

    private Integer pace;

    private Integer shooting;

    private Integer pass;

    private Integer dribbling;

    private Integer defending;

    private Integer physicality;

    private String price;

}
