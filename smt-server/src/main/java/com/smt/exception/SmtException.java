package com.smt.exception;

public class SmtException extends Exception {

  public SmtException() {
  }

  public SmtException(String message) {
    super(message);
  }

  public SmtException(String message, Throwable cause) {
    super(message, cause);
  }
}