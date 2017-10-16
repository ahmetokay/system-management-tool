package com.smt.entity;

import com.core.tr.entity.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "smt_request_history")
public class SmtRequestHistory extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_smt_request_id")
  private SmtRequest smtRequest;

  @Column(name = "time")
  private Timestamp name;

  @Column(name = "status")
  private String status;

  @Column(name = "status_message")
  private String statusMessage;

  public SmtRequestHistory() {
  }

  public SmtRequest getSmtRequest() {
    return smtRequest;
  }

  public void setSmtRequest(SmtRequest smtRequest) {
    this.smtRequest = smtRequest;
  }

  public Timestamp getName() {
    return name;
  }

  public void setName(Timestamp name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStatusMessage() {
    return statusMessage;
  }

  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }
}