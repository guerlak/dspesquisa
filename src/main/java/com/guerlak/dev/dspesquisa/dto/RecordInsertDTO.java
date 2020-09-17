package com.guerlak.dev.dspesquisa.dto;

import com.guerlak.dev.dspesquisa.entities.Record;

public class RecordInsertDTO {

    private Long gameId;
    private String name;
    private Integer age;

    public RecordInsertDTO() {
    }

    public RecordInsertDTO(Record record){
        this.gameId = record.getGame().getId();
        this.name = record.getName();

    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
