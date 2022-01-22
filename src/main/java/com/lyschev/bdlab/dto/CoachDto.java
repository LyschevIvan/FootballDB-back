package com.lyschev.bdlab.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoachDto implements Dto{
    private String name;

    private Integer seasonsInCLub;

    private Integer moneySpent;

    private Integer titlesWon;

}
