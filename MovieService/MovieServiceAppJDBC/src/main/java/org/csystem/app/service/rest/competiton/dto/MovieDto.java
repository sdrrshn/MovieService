package org.csystem.app.service.rest.competiton.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MovieDto {
    private String name;
    private LocalDate sceneDate;
    private BigDecimal cost;
    private Long rating;

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("date")
    @JsonFormat(pattern = "dd-MM-yyy" , shape = JsonFormat.Shape.STRING)
    public LocalDate getSceneDate() {
        return sceneDate;
    }

    public void setSceneDate(LocalDate sceneDate) {
        this.sceneDate = sceneDate;
    }

    @JsonProperty("budget")
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
