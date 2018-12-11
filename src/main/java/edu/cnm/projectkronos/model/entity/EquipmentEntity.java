package edu.cnm.projectkronos.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.projectkronos.view.BaseEquipment;
import edu.cnm.projectkronos.view.BaseEvent;
import io.swagger.annotations.ApiModelProperty;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * The type Equipment entity.
 */
@Entity
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class EquipmentEntity implements BaseEquipment {

  private static EntityLinks entityLinks;

  @Id
  @NonNull
  //@GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "equipment_id", columnDefinition = "CHAR(16) FOR BIT DATA", nullable = false, updatable = false)
  private UUID uuid;
  @NonNull
  private String name;
  @NonNull
  private String identification;
  private String make;
  private String model;
  private String mfcyear;
  private String description;
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

  @JsonSerialize(contentAs = BaseEvent.class)
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipment",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//  @JoinTable(joinColumns = @JoinColumn(name = "equipment_id"),
//      inverseJoinColumns = @JoinColumn(name = "event_id"))
  private List<EventEntity> events = new LinkedList<>();

  @PostConstruct
  private void initEntityLinks() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    EquipmentEntity.entityLinks = entityLinks;
  }

  /**
   * Gets entity links.
   *
   * @return the entity links
   */
  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }

  @ApiModelProperty(value = "Equipment Id", required = true)
  public UUID getUuid() {
    return uuid;
  }

  @ApiModelProperty(required = true)
  public String getName() {
    return name;
  }

  @ApiModelProperty(required = true)
  public String getIdentification() {
    return identification;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public String getYear() {
    return mfcyear;
  }

  public String getDescription() {
    return description;
  }

  public String getMfcyear() {
    return mfcyear;
  }

  /**
   * Gets events associated with the Equipment.
   *
   * @return the events
   */
  @JsonSerialize(contentAs = BaseEvent.class)
  public List<EventEntity> getEvents() {
    return events;
  }

  /**
   * Sets mfcyear.
   *
   * @param mfcyear the mfcyear
   */
  public void setMfcyear(String mfcyear) {
    this.mfcyear = mfcyear;
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
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets identification.
   *
   * @param identification the identification
   */
  public void setIdentification(String identification) {
    this.identification = identification;
  }

  /**
   * Sets make.
   *
   * @param make the make
   */
  public void setMake(String make) {
    this.make = make;
  }

  /**
   * Sets model.
   *
   * @param model the model
   */
  public void setModel(String model) {
    this.model = model;
  }


  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(EquipmentEntity.class, uuid).toUri();
  }
}
