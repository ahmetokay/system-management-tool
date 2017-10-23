package com.smt.exception;

public class SmtConnectException extends SmtException {

  public SmtConnectException() {
  }

  public SmtConnectException(String message) {
    super(message);
  }

  public SmtConnectException(String message, Throwable cause) {
    super(message, cause);
  }
}