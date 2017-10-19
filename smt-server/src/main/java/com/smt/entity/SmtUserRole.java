package com.smt.entity;

import com.core.tr.entity.BaseEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "smt_user_role")
public class SmtUserRole extends BaseEntity {

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "smtUserRole")
  private SmtUser smtUser;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  public SmtUserRole() {
  }

  public SmtUser getSmtUser() {
    return smtUser;
  }

  public void setSmtUser(SmtUser smtUser) {
    this.smtUser = smtUser;
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