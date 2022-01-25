package com.lyschev.bdlab.controllers;

import com.lyschev.bdlab.dto.MatchDto;
import com.lyschev.bdlab.mappers.MatchMapper;
import com.lyschev.bdlab.models.MatchEntity;
import com.lyschev.bdlab.models.TeamEntity;
import com.lyschev.bdlab.repositoryies.MatchRepository;
import com.lyschev.bdlab.repositoryies.TeamRepository;
import com.lyschev.bdlab.utils.StatsService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchMapper matchMapper;

    @GetMapping(value = "/matches")
    public Set<MatchDto> getMatch(){
        return StreamSupport.stream(matchRepository.findAll().spliterator(), false)
                .map(matchMapper::toDto)
                .collect(Collectors.toSet());
    }


    @PostMapping(value = "/matches")
    public void postMatch(@RequestBody MatchDto matchDto){
        MatchEntity match = matchMapper.toEntity(matchDto);

        matchRepository.save(match);
    }

    @PostMapping(value = "/probability")
    public ResponseEntity<Float> getProbability(@RequestBody ProbabilityDto probabilityDto){
        TeamEntity team1 = teamRepository.findById(probabilityDto.getTeam1()).orElse(null);
        TeamEntity team2 = teamRepository.findById(probabilityDto.getTeam2()).orElse(null);
        Float probability = StatsService.getProbability(team1, team2);
        if (probability == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(probability, HttpStatus.OK);
    }

    @Getter
    @Setter
    static class ProbabilityDto{
        Integer team1;
        Integer team2;
    }
}
