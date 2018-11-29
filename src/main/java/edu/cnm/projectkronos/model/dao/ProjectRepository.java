package edu.cnm.projectkronos.model.dao;

import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import edu.cnm.projectkronos.model.entity.ProjectEntity;

public interface ProjectRepository extends CrudRepository<ProjectEntity, UUID> {

  List<ProjectEntity> findAllByOrderByStartTime();

}
