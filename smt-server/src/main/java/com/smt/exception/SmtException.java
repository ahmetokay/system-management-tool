package com.smt.exception;

public class SmtException extends Exception {

  private int code;

  public SmtException() {
  }

  public SmtException(String message) {
    super(message);
  }

  public SmtException(String message, int code) {
    super(message);
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}