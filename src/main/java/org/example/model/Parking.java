package org.example.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Parking {
  private Integer id;
  private Integer car_id;
  private Date entry;
  private Date departure;
  private Double amountPaid;
  private Double permanence;

  public Parking() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCar_id() {
    return car_id;
  }

  public void setCar_id(Integer car_id) {
    this.car_id = car_id;
  }

  public void setEntry(Date entry) {
    this.entry = entry;
  }

  public void setDeparture(Date departure) {
    this.departure = departure;
  }

  public Double getAmountPaid() {
    return amountPaid;
  }

  public void setAmountPaid(Double amountPaid) {
    this.amountPaid = amountPaid;
  }

  public Double getPermanence() {
    return permanence;
  }

  public void setPermanence(Double permanence) {
    this.permanence = permanence;
  }
}
