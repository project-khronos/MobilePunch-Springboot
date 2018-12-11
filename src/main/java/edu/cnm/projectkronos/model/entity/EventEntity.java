package edu.cnm.projectkronos.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.projectkronos.view.BaseEquipment;
import edu.cnm.projectkronos.view.BaseEvent;
import edu.cnm.projectkronos.view.BaseProject;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * The type Event entity.
 */
@Entity
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventEntity implements BaseEvent {

  private static EntityLinks entityLinks;

  @Id
  @NonNull
  //@GeneratedValue(strategy = GenerationType.AUTO)
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
  @JsonIgnore
  private String userId;

  /**
   * Gets user id.
   *
   * @return the user id
   */
  @JsonIgnore
  public String getUserId() {
    return userId;
  }

  /**
   * Sets user id.
   *
   * @param userId the user id
   */
  @JsonIgnore
  public void setUserId(String userId) {
    this.userId = userId;
  }

  @JsonSerialize(contentAs = BaseProject.class)
  @ManyToOne(fetch = FetchType.LAZY,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "project_id")
  private ProjectEntity project;

  @JsonSerialize(contentAs = BaseEquipment.class)
  @ManyToOne(fetch = FetchType.LAZY,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private EquipmentEntity equipment;

  @PostConstruct
  private void initEntityLinks() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    EventEntity.entityLinks = entityLinks;
  }

  /**
   * Gets entity links.
   *
   * @return the entity links
   */
  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }

  @ApiModelProperty(value = "Event ID", required = true)
  public UUID getEvent_id() {
    return uuid;
  }

  @ApiModelProperty(required = true)
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

  /**
   * Gets project.
   *
   * @return the project
   */
  public ProjectEntity getProject() {
    return project;
  }

  /**
   * Sets project.
   *
   * @param project the project
   */
  public void setProject(ProjectEntity project) {
    this.project = project;
  }

  /**
   * Gets equipment.
   *
   * @return the equipment
   */
  @JsonSerialize(contentAs = BaseEquipment.class)
  public EquipmentEntity getEquipment() {
    return equipment;
  }

  /**
   * Sets equipment.
   *
   * @param equipment the equipment
   */
  public void setEquipment(EquipmentEntity equipment) {
    this.equipment = equipment;
  }

  /**
   * Sets uuid.
   *
   * @param uuid the uuid
   */
  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  /**
   * Sets start time.
   *
   * @param startTime the start time
   */
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  /**
   * Sets end time.
   *
   * @param endTime the end time
   */
  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  /**
   * Sets expenses.
   *
   * @param expenses the expenses
   */
  public void setExpenses(BigDecimal expenses) {
    this.expenses = expenses;
  }

  /**
   * Sets income.
   *
   * @param income the income
   */
  public void setIncome(BigDecimal income) {
    this.income = income;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Sets latitude.
   *
   * @param latitude the latitude
   */
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  /**
   * Sets longitude.
   *
   * @param longitude the longitude
   */
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(EventEntity.class, uuid).toUri();
  }
}
