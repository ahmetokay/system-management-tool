package com.smt.exception;

public class SmtUserAlreadyRegisteredException extends SmtException {

  public SmtUserAlreadyRegisteredException() {
  }

  public SmtUserAlreadyRegisteredException(String message) {
    super(message);
  }

  public SmtUserAlreadyRegisteredException(String message, int code) {
    super(message, code);
  }
}