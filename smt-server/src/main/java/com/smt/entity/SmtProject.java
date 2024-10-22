package com.smt.entity;

import com.core.tr.entity.BaseEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "smt_project")
public class SmtProject extends BaseEntity {

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "smtProject")
  private List<SmtRequest> requestList;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_smt_user_id")
  private SmtUser smtUser;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  public SmtProject() {
  }

  public List<SmtRequest> getRequestList() {
    return requestList;
  }

  public void setRequestList(List<SmtRequest> requestList) {
    this.requestList = requestList;
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