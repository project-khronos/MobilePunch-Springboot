package edu.cnm.projectkronos.controller;

import edu.cnm.projectkronos.model.dao.ClientRepository;
import edu.cnm.projectkronos.model.dao.ProjectRepository;
import edu.cnm.projectkronos.model.entity.ClientEntity;
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

  // Post a client
  @ApiOperation(value = "Post a Client", notes = "Posts a Client entity to the api taking into account the user to whom the client record belongs to")
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ClientEntity> postClient(
      @ApiParam(value = "Partial Client definition", required = true) @RequestBody(required = true) ClientEntity client) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    client.setUserId((String) auth.getPrincipal());
    clientRepository.save(client);
    return ResponseEntity.created(client.getHref()).body(client);
  }

  //Gets List of Clients
  @ApiOperation(value = "Get the List of Clients", notes = "Returns the list Clients associated with the user.")
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ClientEntity> list() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userId = ((String) auth.getPrincipal());
    return clientRepository.findAllByUserIdOrderByNameAsc(userId);
  }

  // Get Client
  @ApiOperation(value = "Get a Client.", notes = "Returns a single Client.")
  @GetMapping(value = "{clientId}")
  public ClientEntity getClient(
      @ApiParam(value = "Client Id", required = true) @PathVariable("clientId") UUID clientId) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userId = ((String) auth.getPrincipal());
    return clientRepository.findByUuidAndUserId(clientId, userId);
  }

  //Get list of getProjects for a client
  @ApiOperation(value = "List of Projects", notes = "Returns a list of Projects associated with a the specified Client.")
  @GetMapping(value = "{clientId}/projects")
  public List<ProjectEntity> getProjects(
      @ApiParam(value = "Client Id", required = true) @PathVariable(value = "clientId") UUID clientId) {
    return getClient(clientId).getProjects();
  }

  //Delete a client
  @ApiOperation(value = "Delete a client", notes = "Delete a specified Client.")
  @Transactional
  @DeleteMapping(value = "{clientId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteClient(
      @ApiParam(value = "Client Id", required = true) @PathVariable("clientId") UUID clientId) {
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
