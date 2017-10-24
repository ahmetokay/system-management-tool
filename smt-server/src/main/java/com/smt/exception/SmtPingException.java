package com.smt.exception;

public class SmtPingException extends SmtException {

  public SmtPingException() {
  }

  public SmtPingException(String message) {
    super(message);
  }

  public SmtPingException(String message, Throwable cause) {
    super(message, cause);
  }
}