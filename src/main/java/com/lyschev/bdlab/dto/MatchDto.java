package com.lyschev.bdlab.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
public class MatchDto implements Dto {

    private Integer id;

    private Integer team1_id;

    private Integer team2_id;

    private String league_name;

    private Integer score;

    private Integer tour;

    private String time;
}
