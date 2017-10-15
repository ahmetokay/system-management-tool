package com.smt.entity;

import com.core.tr.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "smt_request_notification")
public class SmtRequestNotification extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_smt_request_id")
  private SmtRequest smtRequest;

  @Column(name = "email")
  private String email;

  @Column(name = "notification_type")
  private String notificationType;

  public SmtRequestNotification() {
  }

  public SmtRequest getSmtRequest() {
    return smtRequest;
  }

  public void setSmtRequest(SmtRequest smtRequest) {
    this.smtRequest = smtRequest;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNotificationType() {
    return notificationType;
  }

  public void setNotificationType(String notificationType) {
    this.notificationType = notificationType;
  }
}
