//package edu.cnm.projectkronos.model.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import java.util.UUID;
//import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
//import javax.persistence.JoinColumn;
//import org.springframework.lang.NonNull;
//
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//@Entity
//public class EventEquipmentEntity {
//
//  @NonNull
//  @JoinColumn(foreignKey = @ForeignKey(name = "event_id"))
//  private UUID event;
//  @NonNull
//  @JoinColumn(foreignKey = @ForeignKey(name = "equipment_id"))
//  private UUID equipment;
//  private double miles;
//  private double hours;
//
//}
