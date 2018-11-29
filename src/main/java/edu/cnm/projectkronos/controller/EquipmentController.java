package edu.cnm.projectkronos.controller;

import edu.cnm.projectkronos.model.dao.EquipmentRepository;
import edu.cnm.projectkronos.model.entity.EquipmentEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

  private EquipmentRepository equipmentRepository;

  @Autowired
  public EquipmentController(EquipmentRepository equipmentRepository) {
    this.equipmentRepository = equipmentRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<EquipmentEntity> list() {
    return equipmentRepository.findAllByOrderByNameAsc();
  }
}
