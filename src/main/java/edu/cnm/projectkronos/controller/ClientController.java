package edu.cnm.projectkronos.controller;

import edu.cnm.projectkronos.model.dao.ClientRepository;
import edu.cnm.projectkronos.model.dao.ProjectRepository;
import edu.cnm.projectkronos.model.entity.ClientEntity;
import edu.cnm.projectkronos.model.entity.ProjectEntity;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
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

@ExposesResourceFor(ClientEntity.class)
@RestController
@RequestMapping("/clients")
public class ClientController {

  private ClientRepository clientRepository;
  private ProjectRepository projectRepository;

  @Autowired
  public ClientController(ClientRepository clientRepository, ProjectRepository projectRepository) {
    this.clientRepository = clientRepository;
    this.projectRepository = projectRepository;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ClientEntity> postClient(@RequestBody ClientEntity client) {
    clientRepository.save(client);
    return ResponseEntity.created(client.getHref()).body(client);
  }

  //Gets List of Clients
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ClientEntity> list() {
    return clientRepository.findAllByOrderByNameAsc();
  }

  // Get Client
  @GetMapping(value = "{clientId}")
  public ClientEntity getClient(@PathVariable("clientId") UUID clientId) {
    return clientRepository.findById(clientId).get();
  }

  @Transactional
  @DeleteMapping(value = "{clientId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteClient(@PathVariable("clientId") UUID clientId) {
    ClientEntity client = getClient(clientId);
    List<ProjectEntity> projects = client.getProjects();
    for (ProjectEntity project : projects) {
      client.getProjects().remove(project);
    }
    projectRepository.saveAll(projects);
    clientRepository.delete(client);
  }


  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }
}
