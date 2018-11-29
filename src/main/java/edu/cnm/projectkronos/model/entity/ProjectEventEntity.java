//package edu.cnm.projectkronos.model.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import java.util.UUID;
//import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
//import javax.persistence.JoinColumn;
//import org.springframework.lang.NonNull;
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//@Entity
//public class ProjectEventEntity {
//
//  @NonNull
//  @JoinColumn(foreignKey = @ForeignKey(name = "project_id"))
//  private UUID project;
//  @NonNull
//  @JoinColumn(foreignKey = @ForeignKey(name = "event_id"))
//  private UUID event;
//}
