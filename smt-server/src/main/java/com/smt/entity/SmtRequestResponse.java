package com.smt.entity;

import com.core.tr.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ahmet on 15.10.2017.
 */
@Entity
@Table(name = "smt_request_response")
public class SmtRequestResponse extends BaseEntity {

    @Column(name = "status")
    private String status;

    public SmtRequestResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}