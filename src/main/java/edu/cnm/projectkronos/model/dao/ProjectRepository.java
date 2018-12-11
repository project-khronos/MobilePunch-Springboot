package edu.cnm.projectkronos.model.dao;

import edu.cnm.projectkronos.model.entity.ProjectEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Project repository.
 */
public interface ProjectRepository extends CrudRepository<ProjectEntity, UUID> {

  /**
   * Find all by user id order by start time list.
   *
   * @param userId the user id
   * @return the list
   */
  List<ProjectEntity> findAllByUserIdOrderByStartTime(String userId);

  /**
   * Find by user id and uuid project entity.
   *
   * @param userId the user id
   * @param uuid the uuid
   * @return the project entity
   */
  ProjectEntity findByUserIdAndUuid(String userId, UUID uuid);
}
