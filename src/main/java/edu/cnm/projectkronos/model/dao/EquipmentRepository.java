package edu.cnm.projectkronos.model.dao;

import edu.cnm.projectkronos.model.entity.EquipmentEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Equipment repository.
 */
public interface EquipmentRepository extends CrudRepository<EquipmentEntity, UUID> {

  /**
   * Find all by user id order by name asc list.
   *
   * @param userId the user id
   * @return the list
   */
  List<EquipmentEntity> findAllByUserIdOrderByNameAsc(String userId);

  /**
   * Find by user id and uuid equipment entity.
   *
   * @param userId the user id
   * @param uuid the uuid
   * @return the equipment entity
   */
  EquipmentEntity findByUserIdAndUuid(String userId, UUID uuid);

}
