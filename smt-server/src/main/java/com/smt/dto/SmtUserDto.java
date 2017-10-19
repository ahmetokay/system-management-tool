package com.smt.dto;

import com.core.tr.model.BaseDto;
import java.util.List;

public class SmtUserDto extends BaseDto {

  private SmtUserSubscriptionDto smtUserSubscription;

  private List<SmtProjectDto> smtProjectList;

  private SmtUserRoleDto smtUserRole;

  private String name;

  private String surname;

  private String email;

  private String password;

  private String address;

  private String city;

  private String country;

  public SmtUserDto() {
  }

  public SmtUserSubscriptionDto getSmtUserSubscription() {
    return smtUserSubscription;
  }

  public void setSmtUserSubscription(SmtUserSubscriptionDto smtUserSubscription) {
    this.smtUserSubscription = smtUserSubscription;
  }

  public List<SmtProjectDto> getSmtProjectList() {
    return smtProjectList;
  }

  public void setSmtProjectList(List<SmtProjectDto> smtProjectList) {
    this.smtProjectList = smtProjectList;
  }

  public SmtUserRoleDto getSmtUserRole() {
    return smtUserRole;
  }

  public void setSmtUserRole(SmtUserRoleDto smtUserRole) {
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