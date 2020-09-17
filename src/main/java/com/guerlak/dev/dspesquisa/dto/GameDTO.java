package com.guerlak.dev.dspesquisa.dto;

import com.guerlak.dev.dspesquisa.entities.Game;
import com.guerlak.dev.dspesquisa.entities.enums.Platform;

public class GameDTO {

    private Long id;
    private String title;
    private Platform platform;

    public GameDTO() {
    }

    public GameDTO(Game game){
        this.id = game.getId();
        this.title = game.getTitle();
        this.platform = game.getPlatform();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
}
