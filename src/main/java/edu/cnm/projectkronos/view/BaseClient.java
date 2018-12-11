package edu.cnm.projectkronos.view;

import java.net.URI;
import java.util.UUID;

/**
 * The interface Base client.
 */
public interface BaseClient {

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
   * Gets phone.
   *
   * @return the phone
   */
  String getPhone();

  /**
   * Gets alt phone.
   *
   * @return the alt phone
   */
  String getAltPhone();

  /**
   * Gets email.
   *
   * @return the email
   */
  String getEmail();

  /**
   * Gets address.
   *
   * @return the address
   */
  String getAddress();

  /**
   * Gets alt address.
   *
   * @return the alt address
   */
  String getAltAddress();

  /**
   * Gets notes.
   *
   * @return the notes
   */
  String getNotes();

  /**
   * Gets href.
   *
   * @return the href
   */
  URI getHref();

}
