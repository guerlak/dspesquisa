package com.guerlak.dev.dspesquisa.resources;

import com.guerlak.dev.dspesquisa.dto.RecordDTO;
import com.guerlak.dev.dspesquisa.dto.RecordInsertDTO;
import com.guerlak.dev.dspesquisa.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/records")
public class RecordResource {

    @Autowired
    private RecordService recordService;

    @GetMapping
    public ResponseEntity<Page<RecordDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction,
            @RequestParam(value = "min", defaultValue = "") String min,
            @RequestParam(value = "max", defaultValue = "") String max
    ){
        Instant minDate = (min.equals("")) ? null : Instant.parse(min);
        Instant maxDate = (max.equals("")) ? null : Instant.parse(max);

        if(linesPerPage == 0){
            linesPerPage = Integer.MAX_VALUE;
        }

        PageRequest pageRequest = PageRequest.of(page,
                linesPerPage,
                Sort.Direction.valueOf(direction),
                orderBy);

        Page<RecordDTO> list = recordService.findByMoment(minDate, maxDate, pageRequest);

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<RecordDTO> create(@RequestBody RecordInsertDTO dto){
        RecordDTO newDto = recordService.create(dto);
        return ResponseEntity.ok().body(newDto);
    }
}
