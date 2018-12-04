package edu.cnm.projectkronos.view;

import edu.cnm.projectkronos.model.entity.ProjectEntity;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;
import java.util.UUID;

public interface BaseEvent {

  UUID getEvent_id();

  Date getStartTime();

  Date getEndTime();

  BigDecimal getExpenses();

  BigDecimal getIncome();

  String getDescription();

  double getLatitude();

  double getLongitude();

  ProjectEntity getProject();

  URI getHref();
}
