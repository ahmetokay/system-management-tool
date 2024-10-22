package com.smt.dto;

import com.core.tr.model.BaseDto;

/**
 * Created by ahmet on 15.10.2017.
 */
public class SmtRequestTypeDto extends BaseDto {

  private String name;

  private String description;

  public SmtRequestTypeDto() {
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