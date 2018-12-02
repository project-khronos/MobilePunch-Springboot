package edu.cnm.projectkronos.controller;

import edu.cnm.projectkronos.model.dao.ClientRepository;
import edu.cnm.projectkronos.model.dao.EquipmentRepository;
import edu.cnm.projectkronos.model.dao.EventRepository;
import edu.cnm.projectkronos.model.dao.ProjectRepository;
import edu.cnm.projectkronos.model.entity.ClientEntity;
import edu.cnm.projectkronos.model.entity.EquipmentEntity;
import edu.cnm.projectkronos.model.entity.EventEntity;
import edu.cnm.projectkronos.model.entity.ProjectEntity;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ExposesResourceFor(EventEntity.class)
@RestController
@RequestMapping("/events")
public class EventController {

  private ProjectRepository projectRepository;
  private EventRepository eventRepository;
  private EquipmentRepository equipmentRepository;

  public EventController(ProjectRepository projectRepository,
      EventRepository eventRepository, EquipmentRepository equipmentRepository) {
    this.projectRepository = projectRepository;
    this.eventRepository = eventRepository;
    this.equipmentRepository = equipmentRepository;
  }

  //Get event
  @GetMapping(value = "{eventId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public EventEntity getEvent(@PathVariable("eventId") UUID eventId) {
    return eventRepository.findById(eventId).get();
  }

  // Get list of Equipment for an event
  @GetMapping(value = "{eventId}/equipment", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<EquipmentEntity> equipment(@PathVariable("eventId") UUID eventId) {
    return getEvent(eventId).getEquipment();
  }

  //Post equipment to event
  @PostMapping(value = "{eventId}/equipment", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EventEntity> postEventEquipment(@PathVariable("eventId") UUID eventId,
      @RequestBody EquipmentEntity partialEquipment) {
    EventEntity event = getEvent(eventId);
    EquipmentEntity equipment = equipmentRepository.findById(partialEquipment.getUuid()).get();
    event.getEquipment().add(equipment);
    eventRepository.save(event);
    return ResponseEntity.created(event.getHref()).body(event);
  }


  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }
}
