package com.lyschev.bdlab.controllers;

import com.lyschev.bdlab.dto.MatchDto;
import com.lyschev.bdlab.mappers.MatchMapper;
import com.lyschev.bdlab.models.TeamEntity;
import com.lyschev.bdlab.repositoryies.MatchRepository;
import com.lyschev.bdlab.repositoryies.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchMapper matchMapper;

    @GetMapping(value = "/result")
    public Set<MatchDto> getMatch(@RequestParam("team1") Integer team1_id, @RequestParam("team2") Integer team2_id){
        TeamEntity team1 = teamRepository.findById(team1_id).orElse(null);
        TeamEntity team2 = teamRepository.findById(team2_id).orElse(null);

        return matchRepository.findAllByTeam1AndTeam2(team1, team2).stream()
                .map(matchMapper::toDto)
                .collect(Collectors.toSet());
    }



}
