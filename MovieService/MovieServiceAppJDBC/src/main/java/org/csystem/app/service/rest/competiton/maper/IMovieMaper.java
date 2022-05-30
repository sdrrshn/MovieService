package org.csystem.app.service.rest.competiton.maper;

import org.csystem.app.service.rest.competiton.dto.MovieDto;
import org.csystem.app.service.rest.competiton.dto.MovieSaveDto;
import org.csystem.app.service.rest.competiton.dto.MoviesDto;
import org.csystem.app.service.rest.competiton.entity.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "MovieMapperImpl", componentModel = "spring")
public interface IMovieMaper {
    MovieDto toMovieDto(Movie movie);
    Movie toMovie(MovieSaveDto movieSaveDto);
    MovieSaveDto toMovieSaveDto (Movie movie);

    default MoviesDto toMoviesDto(List<MovieDto> movieDto) {
        var result = new MoviesDto();
        result.setMovies(movieDto);
        return result;
    }
}
