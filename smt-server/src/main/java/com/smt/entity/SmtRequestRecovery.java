package com.smt.entity;

import com.core.tr.entity.BaseEntity;

import javax.persistence.*;

/**
 * Created by ahmet on 15.10.2017.
 */
@Entity
@Table(name = "smt_request_recovery")
public class SmtRequestRecovery extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_smt_request_id")
    private SmtRequest smtRequest;

    @Column(name = "ip")
    private String ip;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "run_script")
    private String runScript;

    public SmtRequestRecovery() {
    }

    public SmtRequest getSmtRequest() {
        return smtRequest;
    }

    public void setSmtRequest(SmtRequest smtRequest) {
        this.smtRequest = smtRequest;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRunScript() {
        return runScript;
    }

    public void setRunScript(String runScript) {
        this.runScript = runScript;
    }
}