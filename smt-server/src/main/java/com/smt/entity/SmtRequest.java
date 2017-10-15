package com.smt.entity;

import com.core.tr.entity.BaseEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "smt_request")
public class SmtRequest extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_smt_project_id")
  private SmtProject smtProject;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_smt_request_type_id")
  private SmtRequestType smtRequestType;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "smtRequest")
  private List<SmtRequestHistory> smtRequestHistory;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "smtRequest")
  private List<SmtRequestNotification> smtRequestNotification;

  @Column(name = "url")
  private String url;


  @Column(name = "ip")
  private String ip;


  @Column(name = "username")
  private String username;


  @Column(name = "password")
  private String password;


  @Column(name = "refresh_time")
  private Integer refreshTime;

  @Column(name = "try_count")
  private Integer tryCount;


  public SmtRequest() {

  }

  public SmtProject getSmtProject() {
    return smtProject;
  }

  public void setSmtProject(SmtProject smtProject) {
    this.smtProject = smtProject;
  }

  public SmtRequestType getSmtRequestType() {
    return smtRequestType;
  }

  public void setSmtRequestType(SmtRequestType smtRequestType) {
    this.smtRequestType = smtRequestType;
  }

  public List<SmtRequestHistory> getSmtRequestHistory() {
    return smtRequestHistory;
  }

  public void setSmtRequestHistory(List<SmtRequestHistory> smtRequestHistory) {
    this.smtRequestHistory = smtRequestHistory;
  }

  public List<SmtRequestNotification> getSmtRequestNotification() {
    return smtRequestNotification;
  }

  public void setSmtRequestNotification(
      List<SmtRequestNotification> smtRequestNotification) {
    this.smtRequestNotification = smtRequestNotification;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getRefreshTime() {
    return refreshTime;
  }

  public void setRefreshTime(Integer refreshTime) {
    this.refreshTime = refreshTime;
  }

  public Integer getTryCount() {
    return tryCount;
  }

  public void setTryCount(Integer tryCount) {
    this.tryCount = tryCount;
  }
}
