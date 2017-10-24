package com.smt.exception;

public class SmtUnknownHostException extends SmtException {

  public SmtUnknownHostException() {
  }

  public SmtUnknownHostException(String message) {
    super(message);
  }

  public SmtUnknownHostException(String message, int code) {
    super(message, code);
  }
}