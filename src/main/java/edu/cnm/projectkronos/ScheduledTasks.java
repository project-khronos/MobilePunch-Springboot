package edu.cnm.projectkronos;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

  private static Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

  @Scheduled(fixedRate = 10000)
  public void isRunning() {
    log.info("Server is Running");
  }

}
