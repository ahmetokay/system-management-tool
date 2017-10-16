package com.smt.dto;

import com.core.tr.model.BaseDto;

/**
 * Created by ahmet on 15.10.2017.
 */
public class SmtRequestHeaderDto extends BaseDto {

  private SmtRequestDto smtRequest;

  private String key;

  private String value;

  public SmtRequestHeaderDto() {
  }

  public SmtRequestDto getSmtRequest() {
    return smtRequest;
  }

  public void setSmtRequest(SmtRequestDto smtRequest) {
    this.smtRequest = smtRequest;
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