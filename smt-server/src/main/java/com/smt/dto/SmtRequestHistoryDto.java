package com.smt.dto;

import com.core.tr.model.BaseDto;
import java.sql.Timestamp;

/**
 * Created by ahmet on 15.10.2017.
 */
public class SmtRequestHistoryDto extends BaseDto {

  private Long smtRequestId;

  private Timestamp name;

  private String status;

  private String statusMessage;

  public SmtRequestHistoryDto() {
  }

  public Long getSmtRequestId() {
    return smtRequestId;
  }

  public void setSmtRequestId(Long smtRequestId) {
    this.smtRequestId = smtRequestId;
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