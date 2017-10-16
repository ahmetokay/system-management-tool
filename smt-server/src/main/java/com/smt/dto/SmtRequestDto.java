package com.smt.dto;

import com.core.tr.model.BaseDto;

import java.util.List;

/**
 * Created by ahmet on 15.10.2017.
 */
public class SmtRequestDto extends BaseDto {

  private SmtProjectDto smtProject;

  private SmtRequestTypeDto smtRequestType;

  private SmtRequestRecoveryDto smtRequestRecovery;

  private List<SmtRequestHistoryDto> smtRequestHistoryList;

  private List<SmtRequestNotificationDto> smtRequestNotificationList;

  private List<SmtRequestHeaderDto> smtRequestHeaderList;

  private String url;

  private String body;

  private Integer refreshTime;

  private Integer tryCount;

  public SmtRequestDto() {

  }

  public SmtProjectDto getSmtProject() {
    return smtProject;
  }

  public void setSmtProject(SmtProjectDto smtProject) {
    this.smtProject = smtProject;
  }

  public SmtRequestTypeDto getSmtRequestType() {
    return smtRequestType;
  }

  public void setSmtRequestType(SmtRequestTypeDto smtRequestType) {
    this.smtRequestType = smtRequestType;
  }

  public SmtRequestRecoveryDto getSmtRequestRecovery() {
    return smtRequestRecovery;
  }

  public void setSmtRequestRecovery(SmtRequestRecoveryDto smtRequestRecovery) {
    this.smtRequestRecovery = smtRequestRecovery;
  }

  public List<SmtRequestHistoryDto> getSmtRequestHistoryList() {
    return smtRequestHistoryList;
  }

  public void setSmtRequestHistoryList(List<SmtRequestHistoryDto> smtRequestHistoryList) {
    this.smtRequestHistoryList = smtRequestHistoryList;
  }

  public List<SmtRequestNotificationDto> getSmtRequestNotificationList() {
    return smtRequestNotificationList;
  }

  public void setSmtRequestNotificationList(
      List<SmtRequestNotificationDto> smtRequestNotificationList) {
    this.smtRequestNotificationList = smtRequestNotificationList;
  }

  public List<SmtRequestHeaderDto> getSmtRequestHeaderList() {
    return smtRequestHeaderList;
  }

  public void setSmtRequestHeaderList(List<SmtRequestHeaderDto> smtRequestHeaderList) {
    this.smtRequestHeaderList = smtRequestHeaderList;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Integer getRefreshTime() {
    return refreshTime;
  }

  public void setRefreshTime(Integer refreshTime) {
    this.refreshTime = refreshTime;
  }

  public Integer getTryCount() {
    return tryCount;
  }

  public void setTryCount(Integer tryCount) {
    this.tryCount = tryCount;
  }
}