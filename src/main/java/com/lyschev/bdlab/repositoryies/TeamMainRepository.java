package com.lyschev.bdlab.repositoryies;

import com.lyschev.bdlab.models.TeamMainEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TeamMainRepository extends CrudRepository<TeamMainEntity, Integer> {
    ArrayList<TeamMainEntity> findAllByTeamId(Integer id);
}
