package edu.cnm.projectkronos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "quote_id", columnDefinition = "CHAR(16) FOR BIT DATA", nullable = false, updatable = false)
  UUID uuid;
  @NonNull
  String name;
  @NonNull
  String phone;
  String optionalPhone;
  String email;
  @JoinColumn(name = "address_id", nullable = false, updatable = false)
  String adress;
  @Column(length = 4096, nullable = true)
  String notes;

}
