package edu.cnm.projectkronos.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.net.URI;
import java.util.Date;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class ProjectEntity {

  private static EntityLinks entityLinks;

  @Id
  @Column(name = "project_id", columnDefinition = "CHAR(16) FOR BIT DATA", nullable = false, updatable = false)
  private UUID uuid;
  private String name;
  private Date startTime;
  private Date endTime;
  private Date expectedEndTime;
  private String description;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @OrderBy("name ASC")
  private List<ClientEntity> clients = new LinkedList<>();

  @PostConstruct
  private void initEntityLinks() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    ProjectEntity.entityLinks = entityLinks;
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

  public Date getStartTime() {
    return startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public Date getExpectedEndTime() {
    return expectedEndTime;
  }

  public String getDescription() {
    return description;
  }

  public List<ClientEntity> getClients() {
    return clients;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public void setExpectedEndTime(Date expectedEndTime) {
    this.expectedEndTime = expectedEndTime;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setClients(List<ClientEntity> clients) {
    this.clients = clients;
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(ProjectEntity.class, uuid).toUri();
  }
}
