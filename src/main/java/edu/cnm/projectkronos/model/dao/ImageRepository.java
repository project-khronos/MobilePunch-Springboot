package edu.cnm.projectkronos.model.dao;

import edu.cnm.projectkronos.model.entity.ImageEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Image repository.
 */
public interface ImageRepository extends CrudRepository<ImageEntity, UUID> {

  /**
   * Find all by order by uuid asc list.
   *
   * @return the list
   */
  List<ImageEntity> findAllByOrderByUuidAsc();

}
