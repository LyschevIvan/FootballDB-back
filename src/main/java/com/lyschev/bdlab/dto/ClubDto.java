package com.lyschev.bdlab.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClubDto implements Dto {

    private String name;

    private String coachName;

    private String ownerName;

    private String leagueName;

    private String country;

    private String city;

    private Integer lastPos;

    private Integer recentScore;

}
