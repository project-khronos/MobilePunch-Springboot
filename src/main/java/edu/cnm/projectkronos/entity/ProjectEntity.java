package edu.cnm.projectkronos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.GenericGenerator;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class ProjectEntity {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "project_id", columnDefinition = "CHAR(16) FOR BIT DATA", nullable = false, updatable = false)
  UUID uuid;
  long startTime;
  long endTime;
  @JoinColumn(name = "address_id", nullable = false, updatable = false)
  String address;


}
