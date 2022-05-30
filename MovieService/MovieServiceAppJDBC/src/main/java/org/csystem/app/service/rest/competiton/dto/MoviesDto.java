package org.csystem.app.service.rest.competiton.dto;

import java.util.List;

public class MoviesDto {
    private List<MovieDto> movies;

    public List<MovieDto> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDto> movies) {
        this.movies = movies;
    }
}
