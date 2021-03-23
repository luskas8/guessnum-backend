package com.guessnum.back.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Play {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer userId;

  private Integer playsCounter;

  public void setId(Integer id) {
    this.id = id;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public void setPlaysCounter(Integer playsCounter) {
    this.playsCounter = playsCounter;
  }

  public Integer getId() {
    return this.id;
  }

  public Integer getUserId() {
    return this.userId;
  }

  public Integer getPlaysCounter() {
    return this.playsCounter;
  }
}
