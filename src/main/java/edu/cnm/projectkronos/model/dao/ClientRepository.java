package edu.cnm.projectkronos.model.dao;

import edu.cnm.projectkronos.model.entity.ClientEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, UUID> {

  List<ClientEntity> findAllByUserIdOrderByNameAsc(String UserId);

  ClientEntity findByUuidAndUserId(UUID uuid, String userId);
}
