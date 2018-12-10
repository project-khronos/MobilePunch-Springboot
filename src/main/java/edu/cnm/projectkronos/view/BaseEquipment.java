package edu.cnm.projectkronos.view;

import java.net.URI;
import java.util.UUID;

public interface BaseEquipment {

  UUID getUuid();

  String getName();

  String getIdentification();

  String getMake();

  String getModel();

  String getDescription();

  String getMfcyear();

  URI getHref();
}
