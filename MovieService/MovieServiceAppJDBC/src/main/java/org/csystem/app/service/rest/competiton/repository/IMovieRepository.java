package org.csystem.app.service.rest.competiton.repository;

import org.csystem.app.service.rest.competiton.entity.Movie;
import org.csystem.util.data.repository.ICrudRepository;

public interface IMovieRepository extends ICrudRepository<Movie, Long> {
    Iterable<Movie> findByMonth(int month);

    Iterable<Movie> findByYear(int month);

    Iterable<Movie> findByMonthAndYear(int month, int year);

    Iterable<Movie> findByYearBetween(int min, int max);
    Iterable<Movie> findByDirectorId(long directorId);
}
