package com.lyschev.bdlab.controllers;


import com.lyschev.bdlab.dto.TeamDto;
import com.lyschev.bdlab.mappers.TeamMapper;
import com.lyschev.bdlab.models.TeamEntity;
import com.lyschev.bdlab.repositoryies.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class TeamsController {

    @Autowired
    private TeamRepository teamRepository;

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
    public void addTeam(@RequestBody TeamDto teamDto){
        TeamEntity team = teamMapper.toEntity(teamDto);
        teamRepository.save(team);
    }

    @DeleteMapping(value = "/teams/{id}")
    public void deleteTeamById(@PathVariable Integer id){
        teamRepository.deleteById(id);
    }

}
