package edu.cnm.projectkronos.model.dao;

import edu.cnm.projectkronos.model.entity.ImageEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<ImageEntity, UUID> {

  List<ImageEntity> findAllByOrderByUuidAsc();

}
