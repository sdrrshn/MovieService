package org.csystem.app.service.rest.competiton.repository;

import org.csystem.app.service.rest.competiton.entity.Movie;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MovieRepository implements IMovieRepository {
    private static final String count_sql = "select count(*) from movies";
    private static final String find_by_month_sql = "select * from movies where date_part('month',scene_date)=:month";
    private static final String find_by_year_sql = "select * from movies where date_part('year',scene_date)=:year";
    private static final String find_by_year_between_sql = "select * from movies where date_part('year',scene_date) between :min and :max ";
    private static final String find_by_month_and_year_sql = "select * from movies where date_part('month',scene_date)=:month and date_part('year',scene_date)=:year";
    private static final String save_sql = "insert into movies(name, scene_date,cost)values(:name,:sceneDate,:cost)";
    private static final String find_by_director_id = """
            select *
            from movies m inner join movies_to_director mtd on m.movie_id = mtd.movie_id
            where mtd.director_id = :director_id """;
    private final NamedParameterJdbcTemplate jdbcTemplate;


    public MovieRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static void fillCount(ResultSet rs, ArrayList<Long> counts) throws SQLException {
        counts.add(rs.getLong(1));
    }

    private static void fillMovie(ResultSet rs, ArrayList<Movie> movies) throws SQLException {
        do {
            movies.add(new Movie(rs.getInt(1),
                    rs.getString(2),
                    rs.getDate(3).toLocalDate(),
                    rs.getInt(4),
                    BigDecimal.valueOf(rs.getDouble(5)),
                    rs.getDouble(6)));
        } while (rs.next());
    }

    @Override
    public long count() {
        ArrayList<Long> counts = new ArrayList<>();
        jdbcTemplate.query(count_sql, (ResultSet rs) -> fillCount(rs, counts));
        return counts.get(0);
    }

    @Override
    public Iterable<Movie> findByMonth(int month) {
        Map<String, Object> map = new HashMap<>();
        map.put("month", month);
        var movie = new ArrayList<Movie>();
        jdbcTemplate.query(find_by_month_sql, map, (ResultSet rs) -> fillMovie(rs, movie));
        return movie;
    }

    @Override
    public Iterable<Movie> findByYear(int year) {
        Map<String, Object> map = new HashMap<>();
        map.put("year", year);
        var movie = new ArrayList<Movie>();
        jdbcTemplate.query(find_by_year_sql, map, (ResultSet rs) -> fillMovie(rs, movie));
        return movie;
    }


    @Override
    public Iterable<Movie> findByMonthAndYear(int month, int year) {
        Map<String, Object> map = new HashMap<>();
        map.put("month", month);
        map.put("year", year);
        var movie = new ArrayList<Movie>();
        jdbcTemplate.query(find_by_month_and_year_sql, map, (ResultSet rs) -> fillMovie(rs, movie));
        return movie;
    }

    @Override
    public Iterable<Movie> findByYearBetween(int min, int max) {
        Map<String, Object> map = new HashMap<>();
        map.put("min", min);
        map.put("max", max);
        var movie = new ArrayList<Movie>();
        jdbcTemplate.query(find_by_year_between_sql, map, (ResultSet rs) -> fillMovie(rs, movie));
        return movie;
    }

    @Override
    public <S extends Movie> S save(S movie) {
        var keyHold = new GeneratedKeyHolder();
        var parameterSource = new BeanPropertySqlParameterSource(movie);
        parameterSource.registerSqlType("sceneDate", Types.DATE);
        parameterSource.registerSqlType("cost", Types.DECIMAL);
        jdbcTemplate.update(save_sql, parameterSource, keyHold, new String[]{"movie_id"});
        movie.setId(keyHold.getKey().longValue());
        return movie;
    }

    @Override
    public Iterable<Movie> findByDirectorId(long directorId) {
        var paramMap = new HashMap<String, Long>();
        paramMap.put("director_id", directorId);


        var movie = new ArrayList<Movie>();
        jdbcTemplate.query(find_by_director_id, paramMap, (ResultSet rs) -> fillMovie(rs, movie));
        return movie;
    }

    ////////////////////////////////////////////////////////////////////////////////


    @Override
    public void delete(Movie movie) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteAll(Iterable<? extends Movie> movies) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Iterable<Movie> findAll() {
        return null;
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> id) {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return Optional.empty();
    }


    @Override
    public <S extends Movie> Iterable<S> save(Iterable<S> entities) {
        return null;
    }
}
