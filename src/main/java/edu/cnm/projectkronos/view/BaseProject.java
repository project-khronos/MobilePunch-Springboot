package edu.cnm.projectkronos.view;

import java.net.URI;
import java.util.Date;
import java.util.UUID;

/**
 * The interface Base project.
 */
public interface BaseProject {

  /**
   * Gets uuid.
   *
   * @return the uuid
   */
  UUID getUuid();

  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

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
   * Gets expected end time.
   *
   * @return the expected end time
   */
  Date getExpectedEndTime();

  /**
   * Gets description.
   *
   * @return the description
   */
  String getDescription();

  /**
   * Gets href.
   *
   * @return the href
   */
  URI getHref();
}
