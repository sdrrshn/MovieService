package org.csystem.app.service.rest.competiton.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class MovieSaveDto {
    private long id;
    private String name;
    private LocalDate sceneDate;
    private String cost;
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getSceneDate() {
        return sceneDate;
    }

    public void setSceneDate(LocalDate sceneDate) {
        this.sceneDate = sceneDate;
    }


}
