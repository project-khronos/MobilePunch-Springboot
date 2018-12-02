package edu.cnm.projectkronos.model.entity;

import java.net.URI;
import java.util.UUID;

public interface BaseEquipment {

  UUID getUuid();

  String getName();

  String getIdentification();

  String getMake();

  String getModel();

  String getYear();

  String getDescription();

  String getMfcyear();

  URI getHref();
}
