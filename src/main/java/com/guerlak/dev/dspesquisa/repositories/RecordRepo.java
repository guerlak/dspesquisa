package com.guerlak.dev.dspesquisa.repositories;

import com.guerlak.dev.dspesquisa.entities.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface RecordRepo extends JpaRepository<Record, Long> {
    @Query("select obj from Record obj where " +
            "(coalesce(:min, null) is null or obj.moment > :min) " +
            "and (coalesce(:max, null) is null or obj.moment <= :max)")
    public Page<Record> findByMoments(Instant min, Instant max, Pageable pg);
}
