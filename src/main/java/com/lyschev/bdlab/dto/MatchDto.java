package com.lyschev.bdlab.dto;

import com.lyschev.bdlab.models.LeagueEntity;
import com.lyschev.bdlab.models.TeamEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
public class MatchDto implements Dto {

    private Integer id;

    private TeamEntity team1;

    private TeamEntity team2;

    private LeagueEntity league;

    private Integer score;

    private Integer tour;

    private OffsetDateTime time;
}
