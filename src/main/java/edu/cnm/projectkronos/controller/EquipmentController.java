package edu.cnm.projectkronos.controller;

import edu.cnm.projectkronos.model.dao.EquipmentRepository;
import edu.cnm.projectkronos.model.entity.EquipmentEntity;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Equipment controller.
 */
@RestController
@RequestMapping("/equipment")
@ExposesResourceFor(EquipmentEntity.class)
public class EquipmentController {

  private EquipmentRepository equipmentRepository;

  /**
   * Instantiates a new Equipment controller.
   *
   * @param equipmentRepository the equipment repository
   */
  @Autowired
  public EquipmentController(EquipmentRepository equipmentRepository) {
    this.equipmentRepository = equipmentRepository;
    EquipmentEntity noneEquipment = new EquipmentEntity();
    noneEquipment.setName("None");
    noneEquipment.setUuid(new UUID(0L,0L));
    noneEquipment.setDescription("None");
    noneEquipment.setIdentification("None");
    this.equipmentRepository.save(noneEquipment);
  }

  /**
   * Returns thew list of all equipment associated with the user.
   *
   * @return the equipment list
   */
//Get the list of equipment
  @ApiOperation(value = "Get equipment list", notes = "Returns thew list of all equipment associated with the user.")
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<EquipmentEntity> list() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userId = ((String) auth.getPrincipal());
    EquipmentEntity noneEquipment = new EquipmentEntity();
    noneEquipment.setName("None");
    noneEquipment.setUuid(new UUID(0L, 0L));
    noneEquipment.setDescription("None");
    noneEquipment.setIdentification("None");
    noneEquipment.setUserId(userId);
    equipmentRepository.save(noneEquipment);
    return equipmentRepository.findAllByUserIdOrderByNameAsc(userId);
  }

  /**
   * Returns a single equipment entity.
   *
   * @param equipmentId the equipment id
   * @return the equipment
   */
//Get equipment
  @ApiOperation(value = "Get Equipment", notes = "Returns a single equipment entity.")
  @GetMapping(value = "{equipmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public EquipmentEntity getEquipment(
      @ApiParam(value = "Equipment Id", required = true) @PathVariable("equipmentId") UUID equipmentId) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userId = ((String) auth.getPrincipal());
    return equipmentRepository.findByUserIdAndUuid(userId, equipmentId);
  }

  /**
   * Post an Equipment entity to the API.
   *
   * @param equipment Partial equipment definition
   * @return the response entity
   */
//Post Equipment
  @ApiOperation(value = "Post Equipment", notes = "Post an Equipment entity to the API.")
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EquipmentEntity> postEquipment(
      @ApiParam(value = "Partial equipment definition", required = true) @RequestBody EquipmentEntity equipment) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userId = ((String) auth.getPrincipal());
    equipment.setUserId(userId);
    equipmentRepository.save(equipment);
    return ResponseEntity.created(equipment.getHref()).body(equipment);
  }

  /**
   * Deletes a single Equipment entity.
   *
   * @param equipmentId the equipment id
   */
  @ApiOperation(value = "Delete equipoment", notes = "Deletes a single Equipment entity.")
  @Transactional
  @DeleteMapping(value = "{equipmentId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteEquipment(
      @ApiParam(value = "Equipment ID", required = true) @PathVariable("equipmentId") UUID equipmentId) {
    EquipmentEntity equipment = getEquipment(equipmentId);
    equipmentRepository.delete(equipment);
  }


  /**
   * Returns a Resource not found response if the request is improperly formatted.
   */
  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }
}
