package edu.cnm.projectkronos.model.dao;

import edu.cnm.projectkronos.model.entity.EquipmentEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentRepository extends CrudRepository<EquipmentEntity, UUID> {

  List<EquipmentEntity> findAllByOrderByNameAsc();

}
