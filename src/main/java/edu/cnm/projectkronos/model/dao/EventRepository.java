package edu.cnm.projectkronos.model.dao;

import edu.cnm.projectkronos.model.entity.EventEntity;
import edu.cnm.projectkronos.model.entity.ProjectEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Event repository.
 */
public interface EventRepository extends CrudRepository<EventEntity, UUID> {

  /**
   * Find all by user id order by start time list.
   *
   * @param userId the user id
   * @return the list
   */
  List<EventEntity> findAllByUserIdOrderByStartTime(String userId);

  /**
   * Find all by user id and project list.
   *
   * @param userId the user id
   * @param project the project
   * @return the list
   */
  List<EventEntity> findAllByUserIdAndProject(String userId, ProjectEntity project);

  /**
   * Find by user id and uuid event entity.
   *
   * @param userId the user id
   * @param uuid the uuid
   * @return the event entity
   */
  EventEntity findByUserIdAndUuid(String userId, UUID uuid);

}
