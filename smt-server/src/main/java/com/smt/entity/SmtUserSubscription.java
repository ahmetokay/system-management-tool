package com.smt.entity;

import com.core.tr.entity.BaseEntity;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "smt_user_subscription")
public class SmtUserSubscription extends BaseEntity {

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_smt_subscription_id")
  private SmtSubscription smtSubscription;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_smt_user_id")
  private SmtUser smtUser;

  @Column(name = "start_date")
  private Timestamp startDate;

  @Column(name = "end_date")
  private Timestamp endDate;

  public SmtUserSubscription() {
  }

  public SmtSubscription getSmtSubscription() {
    return smtSubscription;
  }

  public void setSmtSubscription(SmtSubscription smtSubscription) {
    this.smtSubscription = smtSubscription;
  }

  public SmtUser getSmtUser() {
    return smtUser;
  }

  public void setSmtUser(SmtUser smtUser) {
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