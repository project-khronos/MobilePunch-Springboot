package edu.cnm.projectkronos.controller;

import edu.cnm.projectkronos.model.dao.EquipmentRepository;
import edu.cnm.projectkronos.model.dao.EventRepository;
import edu.cnm.projectkronos.model.dao.ProjectRepository;
import edu.cnm.projectkronos.model.entity.EquipmentEntity;
import edu.cnm.projectkronos.model.entity.EventEntity;
import edu.cnm.projectkronos.model.entity.ProjectEntity;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.NoSuchElementException;
import java.util.UUID;
import javax.transaction.Transactional;
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
 * The type Event controller.
 */
@ExposesResourceFor(EventEntity.class)
@RestController
@RequestMapping("/events")
public class EventController {

  private ProjectRepository projectRepository;
  private EventRepository eventRepository;
  private EquipmentRepository equipmentRepository;

  /**
   * Instantiates a new Event controller.
   *
   * @param projectRepository the project repository
   * @param eventRepository the event repository
   * @param equipmentRepository the equipment repository
   */
  public EventController(ProjectRepository projectRepository,
      EventRepository eventRepository, EquipmentRepository equipmentRepository) {
    this.projectRepository = projectRepository;
    this.eventRepository = eventRepository;
    this.equipmentRepository = equipmentRepository;
  }

  /**
   * Gets event.
   *
   * @param eventId the event id
   * @return the event
   */
//Get event
  @ApiOperation(value = "Get an Event", notes = "Returns a single Event")
  @GetMapping(value = "{eventId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public EventEntity getEvent(@ApiParam(value = "Event Id") @PathVariable("eventId") UUID eventId) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userId = ((String) auth.getPrincipal());
    return eventRepository.findByUserIdAndUuid(userId, eventId);
  }

  /**
   * Equipment equipment entity.
   *
   * @param eventId the event id
   * @return the equipment entity
   */
// Get list of Equipment for an event
  @ApiOperation(value = "Get Event Equipment", notes = "Returns the Equipment associated with a single event.")
  @GetMapping(value = "{eventId}/equipment", produces = MediaType.APPLICATION_JSON_VALUE)
  public EquipmentEntity equipment(
      @ApiParam(value = "Event Id") @PathVariable("eventId") UUID eventId) {
    return getEvent(eventId).getEquipment();
  }

  /**
   * Post event equipment response entity.
   *
   * @param eventId the event id
   * @param partialEquipment the partial equipment
   * @return the response entity
   */
//Post equipment to event
  @ApiOperation(value = "Post Event Equipment", notes = "Associates an Equipment entity with a single Event.")
  @PostMapping(value = "{eventId}/equipment", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EventEntity> postEventEquipment(
      @ApiParam(value = "Event Id") @PathVariable("eventId") UUID eventId,
      @RequestBody EquipmentEntity partialEquipment) {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userId = ((String) auth.getPrincipal());
    EventEntity event = getEvent(eventId);
    EquipmentEntity equipment = equipmentRepository
        .findByUserIdAndUuid(userId, partialEquipment.getUuid());
    event.setEquipment(equipment);
    equipment.getEvents().add(event);
    event.setUserId(userId);
    eventRepository.save(event);
    return ResponseEntity.created(event.getHref()).body(event);
  }

  /**
   * Delete event.
   *
   * @param eventId the event id
   */
  @ApiOperation(value = "Delete an Event", notes = "Deletes an Event without deleting the project associated with the Event.")
  @Transactional
  @DeleteMapping(value = "{eventId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteEvent(
      @ApiParam(value = "Event Id", required = true) @PathVariable("eventId") UUID eventId) {
    EventEntity event = getEvent(eventId);
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userId = ((String) auth.getPrincipal());
    ProjectEntity project = projectRepository
        .findByUserIdAndUuid(userId, event.getProject().getUuid());
    project.getEvents().remove(event);
    projectRepository.save(project);
    eventRepository.delete(event);
  }


  /**
   * Not found.
   */
  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }
}
