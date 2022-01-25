package com.lyschev.bdlab.controllers;


import com.lyschev.bdlab.dto.TeamDto;
import com.lyschev.bdlab.dto.TeamMainDto;
import com.lyschev.bdlab.dto.TeamMainPlayerDto;
import com.lyschev.bdlab.mappers.TeamMainMapper;
import com.lyschev.bdlab.mappers.TeamMapper;
import com.lyschev.bdlab.mappers.Wrappers.TeamMainEntityWrapper;
import com.lyschev.bdlab.models.PlayerEntity;
import com.lyschev.bdlab.models.TeamEntity;
import com.lyschev.bdlab.models.TeamMainEntity;
import com.lyschev.bdlab.repositoryies.TeamMainRepository;
import com.lyschev.bdlab.repositoryies.TeamRepository;
import com.lyschev.bdlab.utils.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class TeamsController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMainRepository teamMainRepository;

    @Autowired
    private TeamMainMapper teamMainMapper;

    @Autowired
    private TeamMapper teamMapper;


    @GetMapping(value = "/teams")
    public Set<TeamDto> getAllTeams(){
        Iterable<TeamEntity> teamEntityIterable = teamRepository.findAll();
        return StreamSupport.stream(teamEntityIterable.spliterator(), false)
                .map(teamMapper::toDto).collect(Collectors.toSet());

    }

    @GetMapping(value = "/teams/{id}")
    public TeamDto getTeamById(@PathVariable Integer id){
        Optional<TeamEntity> teamEntityOptional = teamRepository.findById(id);
        return teamEntityOptional.map(teamMapper::toDto).orElseGet(TeamDto::new);
    }

    @PostMapping(value = "/teams")
    public int addTeam(@RequestBody TeamDto teamDto){
        TeamEntity team = teamMapper.toEntity(teamDto);
        return teamRepository.save(team).getId();
    }

    @DeleteMapping(value = "/teams/{id}")
    public void deleteTeamById(@PathVariable Integer id){
        teamRepository.deleteById(id);
    }

    // Post/Get for teams_main
    @PostMapping(value = "/teamsMain")
    public void addTeamMain(@RequestBody TeamMainDto teamMainDtos){
        if (teamMainDtos.getTeamMainPlayerDtos().size() > 11 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "В основном составе не может быть более 11и игроков");
        }
        teamMainRepository.saveAll(teamMainMapper.toEntity(teamMainDtos).getTeamMainEntities());

    }

    @GetMapping(value = "/teamsMain/{id}")
    public ResponseEntity<TeamMainDto> getTeamMain(@PathVariable Integer id){
        ArrayList<TeamMainEntity> teamMainEntities = teamMainRepository.findAllByTeamId(id);
        return new ResponseEntity<>(teamMainMapper.toDto(new TeamMainEntityWrapper(teamMainEntities)), HttpStatus.OK);
    }

    @GetMapping(value = "/stats/{id}")
    public ResponseEntity<Integer> getTeamStats(@PathVariable Integer id){
        TeamEntity team = teamRepository.findById(id).orElse(null);
        int stat = StatsService.getStats(team);
        if (stat != 0)
            return new ResponseEntity<>(stat, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    //Post/Get for teams_sub
}
