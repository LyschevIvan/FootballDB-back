package com.lyschev.bdlab.mappers;

import com.lyschev.bdlab.dto.PlayerDto;
import com.lyschev.bdlab.models.ClubEntity;
import com.lyschev.bdlab.models.PlayerEntity;
import com.lyschev.bdlab.repositoryies.ClubRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;



@Component
public class PlayerMapper extends AbstractMapper<PlayerEntity, PlayerDto>{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ClubRepository clubRepository;


    public PlayerMapper() {
        super(PlayerEntity.class, PlayerDto.class);

    }


    @PostConstruct
    public void setupMapper(){
        modelMapper.createTypeMap(PlayerEntity.class, PlayerDto.class)
                .addMappings(m -> m.skip(PlayerDto::setClubName))
                .setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(PlayerDto.class, PlayerEntity.class)
                .addMappings(m ->m.skip(PlayerEntity::setClub))
                .setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(PlayerDto source, PlayerEntity destination) {
        ClubEntity club = clubRepository.findById(source.getClubName()).orElse(null);
        destination.setClub(club);
    }

    @Override
    void mapSpecificFields(PlayerEntity source, PlayerDto destination) {
        destination.setClubName(source.getClub().getName());
    }
}
