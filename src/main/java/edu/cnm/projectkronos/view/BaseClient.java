package edu.cnm.projectkronos.view;

import java.net.URI;
import java.util.UUID;

public interface BaseClient {

  UUID getUuid();

  String getName();

  String getPhone();

  String getAltPhone();

  String getEmail();

  String getAddress();

  String getAltAddress();

  String getNotes();

  URI getHref();

}
