package com.lyschev.bdlab.controllers;


import com.lyschev.bdlab.dto.PlayerDto;
import com.lyschev.bdlab.mappers.PlayerMapper;
import com.lyschev.bdlab.models.PlayerEntity;
import com.lyschev.bdlab.repositoryies.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerMapper playerMapper;

    @GetMapping(value = "/player/{id}")
    public PlayerDto getPlayer(@PathVariable Integer id){
        Optional<PlayerEntity> playerEntity = playerRepository.findById(id);
        return playerEntity.map(playerMapper::toDto).orElse(null);

    }

    @GetMapping(value = "/players")
    public Set<PlayerDto> getPlayersByClubName(@RequestParam("clubName") String clubName){
        Set<PlayerEntity> playerEntities = playerRepository.findAllByClubName(clubName);
        return playerEntities.stream().map(playerMapper::toDto).collect(Collectors.toSet());
    }

}
