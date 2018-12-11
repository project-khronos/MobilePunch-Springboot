package edu.cnm.projectkronos.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.projectkronos.view.BaseClient;
import edu.cnm.projectkronos.view.BaseProject;
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
 * The Client entity.
 */
@Entity
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientEntity implements BaseClient {

  private static EntityLinks entityLinks;

  @Id
  @NonNull
  //@GeneratedValue(strategy = GenerationType.AUTO)
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
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "client",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<ProjectEntity> projects = new LinkedList<>();

  @PostConstruct
  private void initEntityLinks() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    ClientEntity.entityLinks = entityLinks;
  }

  /**
   * Gets entity links.
   *
   * @return the entity links
   */
  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }

  @ApiModelProperty(value = "Client Id", required = true)
  public UUID getUuid() {
    return uuid;
  }

  @ApiModelProperty(required = true)
  public String getName() {
    return name;
  }

  @ApiModelProperty(required = true)
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

  /**
   * Gets projects associated with the client.
   *
   * @return the projects
   */
  @JsonSerialize(contentAs = BaseProject.class)
  public List<ProjectEntity> getProjects() {
    return projects;
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
   * Sets phone.
   *
   * @param phone the phone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Sets alt phone.
   *
   * @param altPhone the alt phone
   */
  public void setAltPhone(String altPhone) {
    this.altPhone = altPhone;
  }

  /**
   * Sets email.
   *
   * @param email the email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Sets address.
   *
   * @param address the address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Sets alt address.
   *
   * @param altAddress the alt address
   */
  public void setAltAddress(String altAddress) {
    this.altAddress = altAddress;
  }

  /**
   * Sets notes.
   *
   * @param notes the notes
   */
  public void setNotes(String notes) {
    this.notes = notes;
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(ClientEntity.class, uuid).toUri();
  }
}
