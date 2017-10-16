package com.smt.dto;

import com.core.tr.model.BaseDto;

/**
 * @author bocal
 */
public class SmtProjectDto extends BaseDto {

  private String name;

  private String description;

  public SmtProjectDto() {
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