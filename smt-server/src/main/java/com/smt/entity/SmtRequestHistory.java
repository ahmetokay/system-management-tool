package com.smt.entity;

import com.core.tr.entity.BaseEntity;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "smt_request_history")
public class SmtRequestHistory extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_smt_request_id")
  private SmtRequest smtRequest;

  @Column(name = "time")
  private Timestamp time;

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

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
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