package com.smt.dto;

import com.core.tr.model.BaseDto;

public class SmtSubscriptionDto extends BaseDto {

  private String name;

  private String description;

  private Integer requestSize;

  private Integer projectSize;

  public SmtSubscriptionDto() {
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

  public Integer getRequestSize() {
    return requestSize;
  }

  public void setRequestSize(Integer requestSize) {
    this.requestSize = requestSize;
  }

  public Integer getProjectSize() {
    return projectSize;
  }

  public void setProjectSize(Integer projectSize) {
    this.projectSize = projectSize;
  }
}