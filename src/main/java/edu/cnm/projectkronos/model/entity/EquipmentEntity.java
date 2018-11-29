package edu.cnm.projectkronos.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.lang.NonNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class EquipmentEntity {

  @Id
  @Column(name = "equipment_id", columnDefinition = "CHAR(16) FOR BIT DATA", nullable = false, updatable = false)
  private UUID uuid;
  @NonNull
  private String name;
  @NonNull
  private String Identification;
  private String make;
  private String model;
  private String year;
  private String description;

}
