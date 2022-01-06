package com.lyschev.bdlab.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamMainDto implements Dto {

    private Integer id;

    private Integer teamId;

    private Integer playerId;
}
