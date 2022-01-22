package com.lyschev.bdlab.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TeamDto implements Dto {
    private Integer id;

    private String clubName;

    private Integer captain;



    @Override
    public String toString() {
        return "TeamDto{" +
                "id=" + id +
                ", clubName=" + clubName +
                ", captain=" + captain +
                '}';
    }
}
