package edu.cnm.projectkronos.controller;

import edu.cnm.projectkronos.model.dao.ProjectRepository;
import edu.cnm.projectkronos.model.entity.ProjectEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/projects")
public class ProjectController {

  private ProjectRepository projectRepository;

  @Autowired
  public ProjectController(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ProjectEntity> list() {
    return projectRepository.findAllByOrderByStartTime();
  }
}
