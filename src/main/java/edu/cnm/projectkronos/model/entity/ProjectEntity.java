package edu.cnm.projectkronos.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.projectkronos.view.BaseClient;
import edu.cnm.projectkronos.view.BaseEvent;
import edu.cnm.projectkronos.view.BaseProject;
import io.swagger.annotations.ApiModelProperty;
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
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * The type Project entity.
 */
@Entity
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectEntity implements BaseProject {

  private static EntityLinks entityLinks;

  @Id
  @NonNull
  //@GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "project_id", columnDefinition = "CHAR(16) FOR BIT DATA", nullable = false, updatable = false)
  private UUID uuid;
  @NonNull
  private String name;
  @NonNull
  private Date startTime;
  private Date endTime;
  private Date expectedEndTime;
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

  @JsonSerialize(contentAs = BaseClient.class)
  @ManyToOne(fetch = FetchType.LAZY,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private ClientEntity client;

  @JsonSerialize(contentAs = BaseEvent.class)
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "project",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<EventEntity> events = new LinkedList<>();


  @PostConstruct
  private void initEntityLinks() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    ProjectEntity.entityLinks = entityLinks;
  }

  /**
   * Gets entity links.
   *
   * @return the entity links
   */
  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }

  @ApiModelProperty(value = "Project Id", required = true)
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

  /**
   * Gets client.
   *
   * @return the client
   */
  @JsonSerialize(contentAs = BaseClient.class)
  public ClientEntity getClient() {
    return client;
  }

  /**
   * Gets events.
   *
   * @return the events
   */
  @JsonSerialize(contentAs = BaseEvent.class)
  public List<EventEntity> getEvents() {
    return events;
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
   * Sets expected end time.
   *
   * @param expectedEndTime the expected end time
   */
  public void setExpectedEndTime(Date expectedEndTime) {
    this.expectedEndTime = expectedEndTime;
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
   * Sets client.
   *
   * @param client the client
   */
  public void setClient(ClientEntity client) {
    this.client = client;
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(ProjectEntity.class, uuid).toUri();
  }
}
