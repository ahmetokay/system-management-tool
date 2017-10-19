package com.smt.dto;

import com.core.tr.model.BaseDto;
import java.sql.Timestamp;

/**
 * Created by ahmet on 15.10.2017.
 */
public class SmtRequestHistoryDto extends BaseDto {

  private Timestamp time;

  private String status;

  private String statusMessage;

  public SmtRequestHistoryDto() {
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