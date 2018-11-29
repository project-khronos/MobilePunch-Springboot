package edu.cnm.projectkronos.controller;

import edu.cnm.projectkronos.model.dao.ClientRepository;
import edu.cnm.projectkronos.model.entity.ClientEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

  private ClientRepository clientRepository;

  @Autowired
  public ClientController(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ClientEntity> list() {
    return clientRepository.findAllByOrderByNameAsc();
  }
}
