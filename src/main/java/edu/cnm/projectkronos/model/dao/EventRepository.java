package edu.cnm.projectkronos.model.dao;

import edu.cnm.projectkronos.model.entity.EventEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<EventEntity, UUID> {

  List<EventEntity> findAllByOrderByStartTime();

}
