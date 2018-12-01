package edu.cnm.projectkronos.controller;

import edu.cnm.projectkronos.model.dao.ClientRepository;
import edu.cnm.projectkronos.model.entity.ClientEntity;
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

@ExposesResourceFor(ClientEntity.class)
@RestController
@RequestMapping("/clients")
public class ClientController {

  private ClientRepository clientRepository;

  @Autowired
  public ClientController(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
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

  // FIXME returns status 500,  Missing URI template variable 'clientID' for method parameter of type UUID]
  // Get Client
  @GetMapping(value = "{clientId}")
  public ClientEntity getClient(@PathVariable("clientID") UUID clientId) {
    return clientRepository.findById(clientId).get();
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }
}
