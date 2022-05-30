package org.csystem.app.service.rest.competiton.repository;

import org.csystem.app.service.rest.competiton.entity.Director;
import org.csystem.app.service.rest.competiton.entity.DirectorDetail;
import org.csystem.util.data.repository.ICrudRepository;

public interface IDirectoryRepository extends ICrudRepository<Director,Long> {
    Iterable<DirectorDetail> findAllDetail();
    Iterable<DirectorDetail> findByIdMovie(Long movie_id);
}
