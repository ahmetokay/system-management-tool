package com.smt.dto;

import com.core.tr.model.BaseDto;
import java.sql.Timestamp;

public class SmtUserSubscriptionDto extends BaseDto {

  private SmtSubscriptionDto smtSubscription;

  private SmtUserDto smtUser;

  private Timestamp startDate;

  private Timestamp endDate;

  public SmtUserSubscriptionDto() {
  }

  public SmtSubscriptionDto getSmtSubscription() {
    return smtSubscription;
  }

  public void setSmtSubscription(SmtSubscriptionDto smtSubscription) {
    this.smtSubscription = smtSubscription;
  }

  public SmtUserDto getSmtUser() {
    return smtUser;
  }

  public void setSmtUser(SmtUserDto smtUser) {
    this.smtUser = smtUser;
  }

  public Timestamp getStartDate() {
    return startDate;
  }

  public void setStartDate(Timestamp startDate) {
    this.startDate = startDate;
  }

  public Timestamp getEndDate() {
    return endDate;
  }

  public void setEndDate(Timestamp endDate) {
    this.endDate = endDate;
  }
}