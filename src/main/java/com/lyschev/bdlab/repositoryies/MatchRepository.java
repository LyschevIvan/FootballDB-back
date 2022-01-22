package com.lyschev.bdlab.repositoryies;

import com.lyschev.bdlab.dto.MatchDto;
import com.lyschev.bdlab.models.MatchEntity;
import com.lyschev.bdlab.models.TeamEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface MatchRepository extends CrudRepository<MatchEntity, String> {
    Set<MatchEntity> findAllByTeam1AndTeam2(TeamEntity team1, TeamEntity team2);
}
