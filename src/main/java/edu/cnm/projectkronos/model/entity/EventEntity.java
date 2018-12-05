package edu.cnm.projectkronos.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.projectkronos.view.BaseEquipment;
import edu.cnm.projectkronos.view.BaseEvent;
import edu.cnm.projectkronos.view.BaseProject;
import java.math.BigDecimal;
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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Entity
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventEntity implements BaseEvent {

  private static EntityLinks entityLinks;

  @Id
  @NonNull
  //FIXME REMOVE
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "event_id", columnDefinition = "CHAR(16) FOR BIT DATA", nullable = false, updatable = false)
  private UUID uuid;
  @NonNull
  private Date startTime;
  private Date endTime;
  private BigDecimal expenses;
  private BigDecimal income;
  private String description;
  private double latitude;
  private double longitude;

  @ManyToOne(fetch = FetchType.EAGER,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "project_id")
  private ProjectEntity project;

  @ManyToMany(fetch = FetchType.LAZY,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<EquipmentEntity> equipment = new LinkedList<>();

  @PostConstruct
  private void initEntityLinks() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    EventEntity.entityLinks = entityLinks;
  }

  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }

  public UUID getEvent_id() {
    return uuid;
  }

  public Date getStartTime() {
    return startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public BigDecimal getExpenses() {
    return expenses;
  }

  public BigDecimal getIncome() {
    return income;
  }

  public String getDescription() {
    return description;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  @JsonSerialize(contentAs = BaseProject.class)
  public ProjectEntity getProject() {
    return project;
  }

  public void setProject(ProjectEntity project) {
    this.project = project;
  }

  @JsonSerialize(contentAs = BaseEquipment.class)
  public List<EquipmentEntity> getEquipment() {
    return equipment;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public void setExpenses(BigDecimal expenses) {
    this.expenses = expenses;
  }

  public void setIncome(BigDecimal income) {
    this.income = income;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(EventEntity.class, uuid).toUri();
  }
}
