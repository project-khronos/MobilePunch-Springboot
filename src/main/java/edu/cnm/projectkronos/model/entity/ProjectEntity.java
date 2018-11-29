package edu.cnm.projectkronos.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
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



}
