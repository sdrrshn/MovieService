package org.csystem.app.service.rest.competiton.dal;

import org.csystem.app.service.rest.competiton.entity.DirectorDetail;
import org.csystem.app.service.rest.competiton.entity.Movie;
import org.csystem.app.service.rest.competiton.repository.IDirectoryRepository;
import org.csystem.app.service.rest.competiton.repository.IMovieRepository;
import org.springframework.stereotype.Component;

@Component
public class MovieServiceHelper {
    private final IMovieRepository movieRepository;
    private final IDirectoryRepository directoryRepository;

    public MovieServiceHelper(IMovieRepository movieRepository, IDirectoryRepository directoryRepository) {
        this.movieRepository = movieRepository;
        this.directoryRepository = directoryRepository;
    }

    public long movieCount() {
        return movieRepository.count();
    }

    public Iterable<Movie> movieFindByMonth(int month) {
        return movieRepository.findByMonth(month);
    }

    public Iterable<Movie> movieFindByYear(int year) {
        return movieRepository.findByYear(year);
    }

    public Iterable<Movie> monthFindByMonthAndYear(int month, int year) {
        return movieRepository.findByMonthAndYear(month, year);
    }

    public Iterable<Movie> monthFindByYearBetween(int min, int max) {
        return movieRepository.findByYearBetween(min, max);
    }
    public Movie  save(Movie movie){
        return movieRepository.save(movie);
    }


    public Iterable<Movie> findByDirectorId(long directorId){
        return movieRepository.findByDirectorId(directorId);
    }


    ////////////////////////////////////////////////////////////////////////////////
    public Iterable<DirectorDetail> findAllDirector(){
        return directoryRepository.findAllDetail();
    }
    public Iterable<DirectorDetail> findByMovieId(long movieId){
        return directoryRepository.findByIdMovie(movieId);
    }
}
