package edu.cnm.projectkronos.model.entity;

import java.net.URI;
import java.util.Date;
import java.util.UUID;

public interface BaseProject {

  UUID getUuid();

  String getName();

  Date getStartTime();

  Date getEndTime();

  Date getExpectedEndTime();

  String getDescription();

  URI getHref();
}
