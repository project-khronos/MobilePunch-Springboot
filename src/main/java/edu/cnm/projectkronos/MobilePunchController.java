package edu.cnm.projectkronos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobilePunchController {


  @GetMapping(path = "/testint", produces = "text/plain")
  public String get(@RequestParam(name = "int", defaultValue = "0") int invalue) {
    return Integer.toString(invalue);
  }
}
