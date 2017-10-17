package com.smt.dto;

import com.core.tr.model.BaseDto;

/**
 * Created by ahmet on 15.10.2017.
 */
public class SmtRequestHeaderDto extends BaseDto {

  private Long smtRequestId;

  private String key;

  private String value;

  public SmtRequestHeaderDto() {
  }

  public Long getSmtRequestId() {
    return smtRequestId;
  }

  public void setSmtRequestId(Long smtRequestId) {
    this.smtRequestId = smtRequestId;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}