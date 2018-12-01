package edu.cnm.projectkronos.controller;

import edu.cnm.projectkronos.model.dao.ClientRepository;
import edu.cnm.projectkronos.model.dao.EventRepository;
import edu.cnm.projectkronos.model.dao.ProjectRepository;
import edu.cnm.projectkronos.model.entity.EventEntity;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ExposesResourceFor(EventEntity.class)
@RestController
@RequestMapping("/events")
public class EventController {

  private ProjectRepository projectRepository;
  private EventRepository eventRepository;

  public EventController(ProjectRepository projectRepository,
      EventRepository eventRepository) {
    this.projectRepository = projectRepository;
    this.eventRepository = eventRepository;
  }

  @GetMapping(value = "{eventId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public EventEntity getEvent(@PathVariable("eventId") UUID eventId) {
    return eventRepository.findById(eventId).get();
  }


  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }
}
