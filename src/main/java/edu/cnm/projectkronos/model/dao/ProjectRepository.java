package edu.cnm.projectkronos.model.dao;

import edu.cnm.projectkronos.model.entity.ProjectEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<ProjectEntity, UUID> {

  List<ProjectEntity> findAllByUserIdOrderByStartTime(String userId);

  ProjectEntity findByUserIdAndUuid(String userId, UUID uuid);
}
