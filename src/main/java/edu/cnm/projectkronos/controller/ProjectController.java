package edu.cnm.projectkronos.controller;

import edu.cnm.projectkronos.model.dao.ClientRepository;
import edu.cnm.projectkronos.model.dao.EventRepository;
import edu.cnm.projectkronos.model.dao.ProjectRepository;
import edu.cnm.projectkronos.model.entity.ClientEntity;
import edu.cnm.projectkronos.model.entity.EquipmentEntity;
import edu.cnm.projectkronos.model.entity.EventEntity;
import edu.cnm.projectkronos.model.entity.ProjectEntity;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
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

@ExposesResourceFor(ProjectEntity.class)
@RestController
@RequestMapping("/projects")
public class ProjectController {

  private ProjectRepository projectRepository;
  private EventRepository eventRepository;
  private ClientRepository clientRepository;

  @Autowired
  public ProjectController(ProjectRepository projectRepository, EventRepository eventRepository,
      ClientRepository clientRepository) {
    this.projectRepository = projectRepository;
    this.eventRepository = eventRepository;
    this.clientRepository = clientRepository;
  }

  // Post Project
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProjectEntity> postProject(@RequestBody ProjectEntity project) {
    projectRepository.save(project);
    return ResponseEntity.created(project.getHref()).body(project);
  }

  // Get Projects
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ProjectEntity> list() {
    return projectRepository.findAllByOrderByStartTime();
  }

  // Get A Project
  @GetMapping(value = "{projectId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ProjectEntity get(@PathVariable("projectId") UUID projectId) {
    return projectRepository.findById(projectId).get();
  }

  //FIXME Returns 500 status, 'INSERT on table 'EVENT_ENTITY' caused a violation of foreign key constraint'
// Post event to a project
  @PostMapping(value = "{projectId}/events", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EventEntity> postEvent(@PathVariable("projectId") UUID projectId,
      @RequestBody EventEntity event) {
    ProjectEntity projectEntity = get(projectId);
    projectEntity.getEvents().add(event);
    event.setProject(projectEntity);
    eventRepository.save(event);
    return ResponseEntity.created(event.getHref()).body(event);
  }

  // Get Events for a Project
  @GetMapping(value = "{projectId}/events", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<EventEntity> getEvents(@PathVariable("projectId") UUID projectId) {
    return get(projectId).getEvents();
  }

//  @GetMapping(value = "{projectId}/{eventId}/equipment")
//  public List<EquipmentEntity> getEquipment(
//      @PathVariable("projectId") UUID projectId, @PathVariable("eventId") UUID eventId) {
//
//  }

  // get Clients for project
  @GetMapping(value = "{projectId}/clients")
  public List<ClientEntity> getClients(@PathVariable("projectId") UUID projectId) {
    return get(projectId).getClients();
  }


  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }
}
