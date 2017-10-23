package com.smt.exception;

public class LoginException extends SmtException {

  public LoginException() {
  }

  public LoginException(String message) {
    super(message);
  }

  public LoginException(String message, Throwable cause) {
    super(message, cause);
  }
}