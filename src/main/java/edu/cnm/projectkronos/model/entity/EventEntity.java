package edu.cnm.projectkronos.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class EventEntity {

  private static EntityLinks entityLinks;

  @Id
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

  public UUID getUuid() {
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
