package org.csystem.app.service.rest.competiton.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Movie {
private long id;
private String name;
private LocalDate sceneDate;
private long rating;
private BigDecimal cost;
private double imdb;

    public Movie() {
    }

    public Movie(long id, String name, LocalDate sceneDate, long rating, BigDecimal cost, double imdb) {
        this.id = id;
        this.name = name;
        this.sceneDate = sceneDate;
        this.rating = rating;
        this.cost = cost;
        this.imdb = imdb;
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

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }
}
