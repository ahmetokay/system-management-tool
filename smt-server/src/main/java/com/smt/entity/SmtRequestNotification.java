package com.smt.entity;

import com.core.tr.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "smt_request_notification")
public class SmtRequestNotification extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_smt_request_id")
    private SmtRequest smtRequest;

    @Column(name = "email")
    private String email;

    @Column(name = "sms")
    private String sms;

    @Column(name = "restart")
    private Boolean restart;

    public SmtRequestNotification() {
    }

    public SmtRequest getSmtRequest() {
        return smtRequest;
    }

    public void setSmtRequest(SmtRequest smtRequest) {
        this.smtRequest = smtRequest;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public Boolean getRestart() {
        return restart;
    }

    public void setRestart(Boolean restart) {
        this.restart = restart;
    }
}