package edu.cnm.projectkronos.controller;

import edu.cnm.projectkronos.model.dao.ClientRepository;
import edu.cnm.projectkronos.model.dao.EventRepository;
import edu.cnm.projectkronos.model.dao.ProjectRepository;
import edu.cnm.projectkronos.model.entity.EventEntity;
import edu.cnm.projectkronos.model.entity.ProjectEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ProjectEntity> list() {
    return projectRepository.findAllByOrderByStartTime();
  }

  @GetMapping(value = "{projectId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ProjectEntity get(@PathVariable("projectId") UUID projectId) {
    return projectRepository.findById(projectId).get();
  }
// TODO figure out how to get a list of events associated with a project.

//  @GetMapping(value = "{projectId}/events", produces = MediaType.APPLICATION_JSON_VALUE)
//  public List<EventEntity> getEvents(@PathVariable("projectId") UUID projectId) {
//
//    return get(projectId).getEvents
//  }
}
