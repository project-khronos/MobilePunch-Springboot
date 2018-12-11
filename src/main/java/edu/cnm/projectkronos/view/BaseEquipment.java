package edu.cnm.projectkronos.view;

import java.net.URI;
import java.util.UUID;

/**
 * The interface Base equipment.
 */
public interface BaseEquipment {

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
   * Gets identification.
   *
   * @return the identification
   */
  String getIdentification();

  /**
   * Gets make.
   *
   * @return the make
   */
  String getMake();

  /**
   * Gets model.
   *
   * @return the model
   */
  String getModel();

  /**
   * Gets year.
   *
   * @return the year
   */
  String getYear();

  /**
   * Gets description.
   *
   * @return the description
   */
  String getDescription();

  /**
   * Gets mfcyear.
   *
   * @return the mfcyear
   */
  String getMfcyear();

  /**
   * Gets href.
   *
   * @return the href
   */
  URI getHref();
}
