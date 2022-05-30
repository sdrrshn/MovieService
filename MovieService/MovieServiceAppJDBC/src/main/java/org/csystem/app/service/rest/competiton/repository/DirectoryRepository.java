package org.csystem.app.service.rest.competiton.repository;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import org.csystem.app.service.rest.competiton.entity.Director;
import org.csystem.app.service.rest.competiton.entity.DirectorDetail;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class DirectoryRepository implements IDirectoryRepository {
    private static final String FIND_DIRECTORS_VIA_FULLNAME = """
            select
            case
                    when middle_name isnull then first_name ||' '|| directors.family_name
                    else first_name||' '||directors.middle_name||' '||directors.first_name
            end as  fullname,
                   birth_date
            from directors
            """;
    private static final String FIND_BY_MOVİVE_ID= "select * from get_directors_by_id(:movie_id);";
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public DirectoryRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final void fillDirectoryDetail(ResultSet resultSet, List<DirectorDetail> directorDetails) throws SQLException {
        do {
            var fullname = resultSet.getString(1);
            var birthDate = resultSet.getDate(2).toLocalDate();
            directorDetails.add(new DirectorDetail(fullname, birthDate));
        } while (resultSet.next());
    }


    @Override
    public Iterable<DirectorDetail> findAllDetail() {
        var directors=new ArrayList<DirectorDetail>();
        jdbcTemplate.query(FIND_DIRECTORS_VIA_FULLNAME,(ResultSet rs)->fillDirectoryDetail(rs,directors));
        return directors;
    }

    @Override
    public Iterable<DirectorDetail> findByIdMovie(Long movie_id) {
        var putMap=new HashMap<String, Object>();
        putMap.put("movie_id",movie_id);
        var directors=new ArrayList<DirectorDetail>();
        jdbcTemplate.query(FIND_BY_MOVİVE_ID,putMap,(ResultSet rs)->fillDirectoryDetail(rs,directors));
        return directors;
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public long count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Director director) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Director> directors) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Director> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Director> findAllById(Iterable<Long> longs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Director> findById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Director> S save(S entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Director> Iterable<S> save(Iterable<S> entities) {
        throw new UnsupportedOperationException();
    }


}
