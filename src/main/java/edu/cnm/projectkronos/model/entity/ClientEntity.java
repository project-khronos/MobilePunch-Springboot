package edu.cnm.projectkronos.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class ClientEntity {

  private static EntityLinks entityLinks;

  @Id
  @Column(name = "client_id", columnDefinition = "CHAR(16) FOR BIT DATA", nullable = false, updatable = false)
  private UUID uuid;
  @NonNull
  private String name;
  @NonNull
  private String phone;
  private String altPhone;
  private String email;
  private String address;
  private String altAddress;
  @Column(length = 4096, nullable = true)
  private String notes;

  @ManyToMany(fetch = FetchType.LAZY,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(joinColumns = @JoinColumn(name = "client_id"),
      inverseJoinColumns = @JoinColumn(name = "project_id"))
  private List<ProjectEntity> projects = new LinkedList<>();

  @PostConstruct
  private void initEntityLinks() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    ClientEntity.entityLinks = entityLinks;
  }

  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }

  public UUID getUuid() {
    return uuid;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public String getAltPhone() {
    return altPhone;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }

  public String getAltAddress() {
    return altAddress;
  }

  public String getNotes() {
    return notes;
  }

  public List<ProjectEntity> getProjects() {
    return projects;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setAltPhone(String altPhone) {
    this.altPhone = altPhone;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setAltAddress(String altAddress) {
    this.altAddress = altAddress;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(ClientEntity.class, uuid).toUri();
  }
}
