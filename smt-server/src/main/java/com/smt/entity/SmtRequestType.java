package com.smt.entity;

import com.core.tr.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "smt_request_type")
public class SmtRequestType extends BaseEntity {

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "smtRequestType")
  private SmtRequest smtRequest;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  public SmtRequestType() {
  }

  public SmtRequest getSmtRequest() {
    return smtRequest;
  }

  public void setSmtRequest(SmtRequest smtRequest) {
    this.smtRequest = smtRequest;
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
}
