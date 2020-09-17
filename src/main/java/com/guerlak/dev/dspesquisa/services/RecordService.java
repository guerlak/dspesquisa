package com.guerlak.dev.dspesquisa.services;

import com.guerlak.dev.dspesquisa.dto.RecordDTO;
import com.guerlak.dev.dspesquisa.dto.RecordInsertDTO;
import com.guerlak.dev.dspesquisa.entities.Game;
import com.guerlak.dev.dspesquisa.entities.Record;
import com.guerlak.dev.dspesquisa.repositories.GameRepo;
import com.guerlak.dev.dspesquisa.repositories.RecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordService {

    @Autowired
    private RecordRepo recordRepo;

    @Autowired
    private GameRepo gameRepo;

    @Transactional(readOnly = true)
    public Page<RecordDTO> findByMoment(Instant minDate, Instant maxdate, PageRequest pg){
        //page is already stream
        return recordRepo.findByMoments(minDate, maxdate, pg).map(e -> new RecordDTO(e));
    }

    @Transactional
    public RecordDTO create(RecordInsertDTO dto){

        Record entity = new Record();

        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setMoment(Instant.now());

        Game game = gameRepo.getOne(dto.getGameId());

        entity.setGame(game);
        entity = recordRepo.save(entity);

        return new RecordDTO(entity);
    }
}
