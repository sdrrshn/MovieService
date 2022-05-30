package org.csystem.app.service.rest.competiton.service;

import org.csystem.app.service.rest.competiton.dal.MovieServiceHelper;
import org.csystem.app.service.rest.competiton.dto.DirectorsDetail;
import org.csystem.app.service.rest.competiton.dto.MovieSaveDto;
import org.csystem.app.service.rest.competiton.dto.MoviesDto;
import org.csystem.app.service.rest.competiton.entity.DirectorDetail;
import org.csystem.app.service.rest.competiton.maper.IDirectorMapper;
import org.csystem.app.service.rest.competiton.maper.IMovieMaper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static org.csystem.util.collection.CollectionUtil.*;

@Service
public class MovieAppService {
    private final IDirectorMapper directorMapper;
    private final IMovieMaper movieMaper;
    private final MovieServiceHelper movieServiceHelper;



    public MovieAppService(IDirectorMapper directorMapper, IMovieMaper movieMaper, MovieServiceHelper movieServiceHelper) {
        this.directorMapper = directorMapper;
        this.movieMaper = movieMaper;
        this.movieServiceHelper = movieServiceHelper;
    }

    public Long movieCount() {
        return movieServiceHelper.movieCount();
    }

    public MoviesDto movieFindByMonth(int month) {
        return movieMaper.toMoviesDto(toList(movieServiceHelper.movieFindByMonth(month), movieMaper::toMovieDto));
    }

    public MoviesDto movieFindByYear(int year) {
        return movieMaper.toMoviesDto(toList(movieServiceHelper.movieFindByYear(year), movieMaper::toMovieDto));
    }

    public MoviesDto movieMonthFindByMonthAndYear(int month, int year) {
        return movieMaper.toMoviesDto(toList(movieServiceHelper.monthFindByMonthAndYear(month, year), movieMaper::toMovieDto));
    }

    public MoviesDto movieMonthFindByYearBetween(int min, int max) {
        return movieMaper.toMoviesDto(toList(movieServiceHelper.monthFindByYearBetween(min, max), movieMaper::toMovieDto));


    }
    public MovieSaveDto saveMovie(MovieSaveDto movie){
        return movieMaper.toMovieSaveDto(movieServiceHelper.save(movieMaper.toMovie(movie))) ;
    }
    public MoviesDto findByDirectorId(long directorId){
        return movieMaper.toMoviesDto(toList(movieServiceHelper.findByDirectorId(directorId),movieMaper::toMovieDto));
    }

    /////////////////////////////////////////////////////////////////////////////////
    public Iterable<DirectorDetail> findAllDirector(){
        return movieServiceHelper.findAllDirector();
    }
 public DirectorsDetail findByMovieId(Long movieId){
        return directorMapper.toDirectorsDetail(toList(movieServiceHelper.findByMovieId(movieId),directorMapper::toDirectorDetailDto));
    }


}
