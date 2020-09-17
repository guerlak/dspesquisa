package com.guerlak.dev.dspesquisa.services;

import com.guerlak.dev.dspesquisa.dto.GameDTO;
import com.guerlak.dev.dspesquisa.repositories.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo;

    @Transactional(readOnly = true)
    public List<GameDTO> findAll(){
        return gameRepo.findAll()
                .stream()
                .map(x -> new GameDTO(x)).collect(Collectors.toList());
    }
}
