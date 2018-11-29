package edu.cnm.projectkronos.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.net.URI;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class ImageEntity {

  private static EntityLinks entityLinks;

  @Id
  @Column(name = "image_id", columnDefinition = "CHAR(16) FOR BIT DATA", nullable = false, updatable = false)
  private UUID uuid;
  private String description;

  @PostConstruct
  private void initEntityLinks() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    ImageEntity.entityLinks = entityLinks;
  }

  public UUID getUuid() {
    return uuid;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(ImageEntity.class, uuid).toUri();
  }
}
