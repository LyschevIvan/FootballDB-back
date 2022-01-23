package com.lyschev.bdlab.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class TeamMainDto implements Dto {

    private Integer teamId;

    private ArrayList<TeamMainPlayerDto> teamMainPlayerDtos;
}
