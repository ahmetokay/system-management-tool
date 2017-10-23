package com.smt.exception;

public class SmtLoginException extends SmtException {

  public SmtLoginException() {
  }

  public SmtLoginException(String message) {
    super(message);
  }

  public SmtLoginException(String message, Throwable cause) {
    super(message, cause);
  }
}