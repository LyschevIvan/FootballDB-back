package com.lyschev.bdlab.mappers.Wrappers;

import com.lyschev.bdlab.models.EntityInterface;
import com.lyschev.bdlab.models.TeamMainEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class TeamMainEntityWrapper implements EntityInterface {
    private ArrayList<TeamMainEntity> teamMainEntities;

    public TeamMainEntityWrapper(ArrayList<TeamMainEntity> teamMainEntities) {
        this.teamMainEntities = teamMainEntities;
    }

    public TeamMainEntityWrapper() {
    }
}
