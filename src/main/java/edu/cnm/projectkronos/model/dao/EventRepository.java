package edu.cnm.projectkronos.model.dao;

import edu.cnm.projectkronos.model.entity.EventEntity;
import edu.cnm.projectkronos.model.entity.ProjectEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<EventEntity, UUID> {

  List<EventEntity> findAllByUserIdOrderByStartTime(String userId);

  List<EventEntity> findAllByUserIdAndProject(String userId, ProjectEntity project);

  EventEntity findByUserIdAndUuid(String userId, UUID uuid);

}
