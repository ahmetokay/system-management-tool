package com.smt.dto;

import com.core.tr.model.BaseDto;

/**
 * Created by ahmet on 15.10.2017.
 */
public class SmtRequestResponseDto extends BaseDto {

  private String code;

  public SmtRequestResponseDto() {
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}