package com.smt.entity;

import com.core.tr.entity.BaseEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "smt_subscription")
public class SmtSubscription extends BaseEntity {

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "smtSubscription")
  private SmtUserSubscription smtUserSubscription;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "request_size")
  private Integer requestSize;

  @Column(name = "project_size")
  private Integer projectSize;

  public SmtSubscription() {
  }

  public SmtUserSubscription getSmtUserSubscription() {
    return smtUserSubscription;
  }

  public void setSmtUserSubscription(SmtUserSubscription smtUserSubscription) {
    this.smtUserSubscription = smtUserSubscription;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getRequestSize() {
    return requestSize;
  }

  public void setRequestSize(Integer requestSize) {
    this.requestSize = requestSize;
  }

  public Integer getProjectSize() {
    return projectSize;
  }

  public void setProjectSize(Integer projectSize) {
    this.projectSize = projectSize;
  }
}