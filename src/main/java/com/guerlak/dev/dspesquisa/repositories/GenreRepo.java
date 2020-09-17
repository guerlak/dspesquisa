package com.guerlak.dev.dspesquisa.repositories;

import com.guerlak.dev.dspesquisa.entities.Genre;
import com.guerlak.dev.dspesquisa.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepo extends JpaRepository<Genre, Long> {
}
