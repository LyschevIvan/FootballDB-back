package com.lyschev.bdlab.mappers;

import com.lyschev.bdlab.dto.TeamDto;
import com.lyschev.bdlab.models.ClubEntity;
import com.lyschev.bdlab.models.TeamEntity;
import com.lyschev.bdlab.repositoryies.ClubRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TeamMapper extends AbstractMapper<TeamEntity, TeamDto>{

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TeamMapper() {
        super(TeamEntity.class, TeamDto.class);
    }

    @PostConstruct
    private void setupMapper(){
        modelMapper.createTypeMap(TeamEntity.class, TeamDto.class)
                .addMappings(m -> m.skip(TeamDto::setClubName))
                .setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(TeamDto.class, TeamEntity.class)
                .addMappings(m -> m.skip(TeamEntity::setClub))
                .addMappings(m -> m.skip(TeamEntity::setTeamsMainEntities))
                //add sub team
                .setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(TeamDto source, TeamEntity destination) {
        ClubEntity club = clubRepository.findById(source.getClubName()).orElse(null);
        destination.setClub(club);
        destination.setTeamsMainEntities(null);

    }


    @Override
    void mapSpecificFields(TeamEntity source, TeamDto destination) {
        destination.setClubName(source.getClub().getName());

    }
}
