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

    @Column(name = "code")
    private String code;

    public SmtRequestResponse() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}