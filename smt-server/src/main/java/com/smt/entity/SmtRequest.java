package com.smt.entity;

import com.core.tr.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "smt_request")
public class SmtRequest extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_smt_project_id")
    private SmtProject smtProject;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_smt_request_type_id")
    private SmtRequestType smtRequestType;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "smtRequest")
    private SmtRequestRecovery smtRequestRecovery;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "smtRequest")
    private List<SmtRequestHistory> smtRequestHistoryList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "smtRequest")
    private List<SmtRequestNotification> smtRequestNotificationList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "smtRequest")
    private List<SmtRequestHeader> smtRequestHeaderList;

    @Column(name = "url")
    private String url;

    @Column(name = "bodu")
    private String body;

    @Column(name = "refresh_time")
    private Integer refreshTime;

    @Column(name = "try_count")
    private Integer tryCount;

    public SmtRequest() {

    }

    public SmtProject getSmtProject() {
        return smtProject;
    }

    public void setSmtProject(SmtProject smtProject) {
        this.smtProject = smtProject;
    }

    public SmtRequestType getSmtRequestType() {
        return smtRequestType;
    }

    public void setSmtRequestType(SmtRequestType smtRequestType) {
        this.smtRequestType = smtRequestType;
    }

    public SmtRequestRecovery getSmtRequestRecovery() {
        return smtRequestRecovery;
    }

    public void setSmtRequestRecovery(SmtRequestRecovery smtRequestRecovery) {
        this.smtRequestRecovery = smtRequestRecovery;
    }

    public List<SmtRequestHistory> getSmtRequestHistoryList() {
        return smtRequestHistoryList;
    }

    public void setSmtRequestHistoryList(List<SmtRequestHistory> smtRequestHistoryList) {
        this.smtRequestHistoryList = smtRequestHistoryList;
    }

    public List<SmtRequestNotification> getSmtRequestNotificationList() {
        return smtRequestNotificationList;
    }

    public void setSmtRequestNotificationList(List<SmtRequestNotification> smtRequestNotificationList) {
        this.smtRequestNotificationList = smtRequestNotificationList;
    }

    public List<SmtRequestHeader> getSmtRequestHeaderList() {
        return smtRequestHeaderList;
    }

    public void setSmtRequestHeaderList(List<SmtRequestHeader> smtRequestHeaderList) {
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