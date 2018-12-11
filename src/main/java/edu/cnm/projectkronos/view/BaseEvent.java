package edu.cnm.projectkronos.view;

import edu.cnm.projectkronos.model.entity.ProjectEntity;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;
import java.util.UUID;

/**
 * The interface Base event.
 */
public interface BaseEvent {

  /**
   * Gets event id.
   *
   * @return the event id
   */
  UUID getEvent_id();

  /**
   * Gets start time.
   *
   * @return the start time
   */
  Date getStartTime();

  /**
   * Gets end time.
   *
   * @return the end time
   */
  Date getEndTime();

  /**
   * Gets expenses.
   *
   * @return the expenses
   */
  BigDecimal getExpenses();

  /**
   * Gets income.
   *
   * @return the income
   */
  BigDecimal getIncome();

  /**
   * Gets description.
   *
   * @return the description
   */
  String getDescription();

  /**
   * Gets latitude.
   *
   * @return the latitude
   */
  double getLatitude();

  /**
   * Gets longitude.
   *
   * @return the longitude
   */
  double getLongitude();

  /**
   * Gets href.
   *
   * @return the href
   */
  URI getHref();
}
