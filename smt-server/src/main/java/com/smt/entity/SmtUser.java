package com.smt.entity;

import com.core.tr.entity.BaseEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "smt_user")
public class SmtUser extends BaseEntity {

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "smtSubscription")
  private SmtUserSubscription smtUserSubscription;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "smtUser")
  private List<SmtProject> smtProjectList;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_smt_user_role_id")
  private SmtUserRole smtUserRole;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "address")
  private String address;

  @Column(name = "city")
  private String city;

  @Column(name = "country")
  private String country;

  public SmtUser() {
  }

  public SmtUserSubscription getSmtUserSubscription() {
    return smtUserSubscription;
  }

  public void setSmtUserSubscription(SmtUserSubscription smtUserSubscription) {
    this.smtUserSubscription = smtUserSubscription;
  }

  public List<SmtProject> getSmtProjectList() {
    return smtProjectList;
  }

  public void setSmtProjectList(List<SmtProject> smtProjectList) {
    this.smtProjectList = smtProjectList;
  }

  public SmtUserRole getSmtUserRole() {
    return smtUserRole;
  }

  public void setSmtUserRole(SmtUserRole smtUserRole) {
    this.smtUserRole = smtUserRole;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}