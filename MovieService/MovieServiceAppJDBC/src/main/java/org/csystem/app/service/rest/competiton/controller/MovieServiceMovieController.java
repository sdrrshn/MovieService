package org.csystem.app.service.rest.competiton.controller;

import org.csystem.app.service.rest.competiton.dto.MovieSaveDto;
import org.csystem.app.service.rest.competiton.dto.MoviesDto;
import org.csystem.app.service.rest.competiton.service.MovieAppService;
import org.springframework.web.bind.annotation.*;

import static org.csystem.util.collection.CollectionUtil.toList;

@RestController
@RequestMapping("api/movie")
public class MovieServiceMovieController {
    private final MovieAppService movieAppService;

    public MovieServiceMovieController(MovieAppService movieAppService) {
        this.movieAppService = movieAppService;
    }

    @GetMapping("movies/count")
    public Long movieCount() {
        return movieAppService.movieCount();
    }

    @GetMapping("movies/find/sdate/month")
    public MoviesDto movieFindByMonth(@RequestParam(name = "m") int month) {
        return movieAppService.movieFindByMonth(month);
    }

    @GetMapping("movies/find/sdate/year")
    public MoviesDto movieFindByYear(@RequestParam(name = "y") int year) {
        return movieAppService.movieFindByYear(year);
    }

    @GetMapping("movies/find/sdate/my")
    public MoviesDto movieMonthFindByMonthAndYear(@RequestParam(name = "m") int month, @RequestParam(name = "y") int year) {
        return movieAppService.movieMonthFindByMonthAndYear(month, year);
    }

    @GetMapping("movies/find/year/between")
    public MoviesDto movieMonthFindByYearBetween(@RequestParam(name = "min") int min, @RequestParam(name = "max") int max) {
        return movieAppService.movieMonthFindByYearBetween(min, max);
    }

    @GetMapping("movies/find/director")
    public MoviesDto findByDirectoryId(@RequestParam(name = "id") long directoryId) {
        return movieAppService.findByDirectorId(directoryId);
    }

    @PostMapping("movies/save")
    public MovieSaveDto movieSaveDto(@RequestHeader MovieSaveDto movieSaveDto){
        return movieAppService.saveMovie(movieSaveDto);
    }

}
