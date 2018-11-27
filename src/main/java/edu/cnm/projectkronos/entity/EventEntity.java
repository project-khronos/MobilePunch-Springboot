package edu.cnm.projectkronos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class EventEntity {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "event_id", columnDefinition = "CHAR(16) FOR BIT DATA", nullable = false, updatable = false)
  private UUID uuid;
  @NonNull
  private long date;
  private long startTime;
  private long endTime;
  private double miles;
  @JoinColumn(name = "equipment_id")
  private EquipmentEntity equipmentId;
  private double credit;
  @NonNull
  private double expenses;
  @JoinColumn(name = "address_id")
  private AddresEntity address;

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public long getDate() {
    return date;
  }

  public void setDate(long date) {
    this.date = date;
  }

  public long getStartTime() {
    return startTime;
  }

  public void setStartTime(long startTime) {
    this.startTime = startTime;
  }

  public long getEndTime() {
    return endTime;
  }

  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }

  public double getMiles() {
    return miles;
  }

  public void setMiles(double miles) {
    this.miles = miles;
  }

  public double getCredit() {
    return credit;
  }

  public void setCredit(double credit) {
    this.credit = credit;
  }

  public double getExpenses() {
    return expenses;
  }

  public void setExpenses(double expenses) {
    this.expenses = expenses;
  }

  public EquipmentEntity getEquipmentId() {
    return equipmentId;
  }

  public void setEquipmentId(EquipmentEntity equipmentId) {
    this.equipmentId = equipmentId;
  }

  public AddresEntity getAddress() {
    return address;
  }

  public void setAddress(AddresEntity address) {
    this.address = address;
  }
}
