package com.lyschev.bdlab.controllers;


import com.lyschev.bdlab.dto.ClubDto;
import com.lyschev.bdlab.mappers.ClubMapper;
import com.lyschev.bdlab.models.ClubEntity;
import com.lyschev.bdlab.repositoryies.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private ClubMapper clubMapper;

    @GetMapping("/clubs")
    public Set<ClubDto> getAllClubs(){
        Iterable<ClubEntity> clubEntities =  clubRepository.findAll();
        return StreamSupport.stream(clubEntities.spliterator(), false)
                .map(clubMapper::toDto).collect(Collectors.toSet());
    }
}
