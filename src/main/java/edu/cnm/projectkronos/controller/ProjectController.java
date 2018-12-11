package edu.cnm.projectkronos.controller;

import edu.cnm.projectkronos.model.dao.ClientRepository;
import edu.cnm.projectkronos.model.dao.EventRepository;
import edu.cnm.projectkronos.model.dao.ProjectRepository;
import edu.cnm.projectkronos.model.entity.ClientEntity;
import edu.cnm.projectkronos.model.entity.EventEntity;
import edu.cnm.projectkronos.model.entity.ProjectEntity;
import io.swagger.annotations.Api;
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
 * The type Project controller.
 */
@ExposesResourceFor(ProjectEntity.class)
@RestController
@RequestMapping("/projects")
public class ProjectController {

  private ProjectRepository projectRepository;
  private ClientRepository clientRepository;
  private EventRepository eventRepository;

  /**
   * Instantiates a new Project controller.
   *
   * @param projectRepository the project repository
   * @param eventRepository the event repository
   * @param clientRepository the client repository
   */
  @Autowired
  public ProjectController(ProjectRepository projectRepository, EventRepository eventRepository,
      ClientRepository clientRepository) {
    this.projectRepository = projectRepository;
    this.clientRepository = clientRepository;
    this.eventRepository = eventRepository;
  }

  /**
   * Post project response entity.
   *
   * @param project the project
   * @return the response entity
   */
// Post Project
  @ApiOperation(value = "Post a Project", notes = "Posts a Project entity to the api taking into account the user to whom the Project record belongs to")
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProjectEntity> postProject(
      @ApiParam(value = "Partial Project Definition", required = true) @RequestBody ProjectEntity project) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userId = ((String) auth.getPrincipal());
    project.setUserId(userId);
    projectRepository.save(project);
    return ResponseEntity.created(project.getHref()).body(project);
  }

  /**
   * List list.
   *
   * @return the list
   */
// Get Projects
  @ApiOperation(value = "Get Projects", notes = "Returns a list of Projects associated to the user.")
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ProjectEntity> list() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userId = ((String) auth.getPrincipal());
    return projectRepository.findAllByUserIdOrderByStartTime(userId);
  }

  /**
   * Gets project.
   *
   * @param projectId the project id
   * @return the project
   */
// Get A Project
  @ApiOperation(value = "Get a Project", notes = "Returns a single Project. ")
  @GetMapping(value = "{projectId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ProjectEntity getProject(
      @ApiParam(value = "Project Id", required = true) @PathVariable("projectId") UUID projectId) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userId = ((String) auth.getPrincipal());
    return projectRepository.findByUserIdAndUuid(userId, projectId);
  }

  /**
   * Post client response entity.
   *
   * @param projectId the project id
   * @param partialClient the partial client
   * @return the response entity
   */
// Post a client to project
  @ApiOperation(value = "Post a Client to a Project", notes = "Associates a single Client to a single Project.")
  @PostMapping(value = "{projectId}/clients", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProjectEntity> postClient(
      @ApiParam(value = "Project Id", required = true) @PathVariable("projectId") UUID projectId,
      @ApiParam(value = "Client Id", required = true) @RequestBody ClientEntity partialClient) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userId = ((String) auth.getPrincipal());
    ProjectEntity project = getProject(projectId);
    ClientEntity client = clientRepository.findByUuidAndUserId(partialClient.getUuid(), userId);
    // client.getProjects().add(project);
    project.setClient(client);
    // clientRepository.save(client);
    projectRepository.save(project);
    return ResponseEntity.created(project.getHref()).body(project);
  }

  /**
   * Post event response entity.
   *
   * @param projectId the project id
   * @param event the event
   * @return the response entity
   */
// Post event to a project
  @ApiOperation(value = "Post an Event to a Project", notes = "Associates a new Event with a single Project.")
  @PostMapping(value = "{projectId}/events", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EventEntity> postEvent(
      @ApiParam(value = "Project Id", required = true) @PathVariable(value = "projectId") UUID projectId,
      @ApiParam(value = "Partial Event definition", required = true) @RequestBody EventEntity event) {
    ProjectEntity projectEntity = getProject(projectId);
    event.setProject(projectEntity);
    eventRepository.save(event);
    return ResponseEntity.created(event.getHref()).body(event);
  }

  /**
   * Gets events.
   *
   * @param projectId the project id
   * @return the events
   */
// Get Events for a Project
  @ApiOperation(value = "Get Project Events", notes = "Returns the list of Events associated with a single Project.")
  @GetMapping(value = "{projectId}/events", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<EventEntity> getEvents(
      @ApiParam(value = "Project Id", required = true) @PathVariable("projectId") UUID projectId) {
    return getProject(projectId).getEvents();
  }

  /**
   * Gets clients.
   *
   * @param projectId the project id
   * @return the clients
   */
// Get Client for project
  @ApiOperation(value = "Get Project Client", notes = "Returns the Client associated with the Project.")
  @GetMapping(value = "{projectId}/clients")
  public ClientEntity getClients(
      @ApiParam(value = "Project Id", required = true) @PathVariable("projectId") UUID projectId) {
    return getProject(projectId).getClient();
  }

  /**
   * Delete project.
   *
   * @param projectId the project id
   */
//Delete a project
  @ApiOperation(value = "Delete Project", notes = "Delete a Project and its Events.")
  @Transactional
  @DeleteMapping(value = "{projectId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteProject(
      @ApiParam(value = "Project Id", required = true) @PathVariable("projectId") UUID projectId) {
    ProjectEntity project = getProject(projectId);
    ClientEntity client = project.getClient();
    client.getProjects().remove(project);
    clientRepository.save(client);
    projectRepository.delete(project);
  }


  /**
   * Not found.
   */
  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }
}

