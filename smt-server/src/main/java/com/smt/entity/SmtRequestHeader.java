package com.smt.entity;

import com.core.tr.entity.BaseEntity;

import javax.persistence.*;

/**
 * Created by ahmet on 15.10.2017.
 */
@Entity
@Table(name = "smt_request_header")
public class SmtRequestHeader extends BaseEntity {

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_smt_request_id")
  private SmtRequest smtRequest;

  @Column(name = "key")
  private String key;

  @Column(name = "value")
  private String value;

  public SmtRequestHeader() {
  }

  public SmtRequest getSmtRequest() {
    return smtRequest;
  }

  public void setSmtRequest(SmtRequest smtRequest) {
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