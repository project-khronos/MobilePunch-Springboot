package edu.cnm.projectkronos.model.dao;

import edu.cnm.projectkronos.model.entity.ClientEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Client repository.
 */
public interface ClientRepository extends CrudRepository<ClientEntity, UUID> {

  /**
   * Find all by user id order by name asc list.
   *
   * @param UserId the user id
   * @return the list
   */
  List<ClientEntity> findAllByUserIdOrderByNameAsc(String UserId);

  /**
   * Find by uuid and user id client entity.
   *
   * @param uuid the uuid
   * @param userId the user id
   * @return the client entity
   */
  ClientEntity findByUuidAndUserId(UUID uuid, String userId);
}
