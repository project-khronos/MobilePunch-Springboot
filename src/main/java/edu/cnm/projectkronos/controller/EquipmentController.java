package edu.cnm.projectkronos.controller;

import edu.cnm.projectkronos.model.dao.EquipmentRepository;
import edu.cnm.projectkronos.model.entity.EquipmentEntity;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

  private EquipmentRepository equipmentRepository;

  @Autowired
  public EquipmentController(EquipmentRepository equipmentRepository) {
    this.equipmentRepository = equipmentRepository;
  }

  //Get the list of equipment
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<EquipmentEntity> list() {
    return equipmentRepository.findAllByOrderByNameAsc();
  }

  //Get equipment
  @GetMapping(value = "{equipmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public EquipmentEntity getEquipment(@PathVariable("equipmentId") UUID equipmentId) {
    return equipmentRepository.findById(equipmentId).get();
  }

  //Post Equipment
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EquipmentEntity> postEquipment(@RequestBody EquipmentEntity equipment) {
    equipmentRepository.save(equipment);
    return ResponseEntity.created(equipment.getHref()).body(equipment);
  }

  @Transactional
  @DeleteMapping(value = "{equipmentId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteEquipment(@PathVariable("equipmentId") UUID equipmentId) {
    EquipmentEntity equipment = getEquipment(equipmentId);
    equipmentRepository.delete(equipment);
  }


  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }
}
