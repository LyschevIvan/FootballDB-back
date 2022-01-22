package com.lyschev.bdlab.controllers;

import com.lyschev.bdlab.dto.MatchDto;
import com.lyschev.bdlab.mappers.MatchMapper;
import com.lyschev.bdlab.models.TeamEntity;
import com.lyschev.bdlab.repositoryies.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchMapper matchMapper;

    /*@GetMapping(value = "/result")
    public MatchDto getMatch(@RequestParam("team1") TeamEntity team1, @RequestParam("team2") TeamEntity team2){

    }

    private*/
}
