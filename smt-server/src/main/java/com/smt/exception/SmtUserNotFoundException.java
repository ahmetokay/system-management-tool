package com.smt.exception;

public class SmtUserNotFoundException extends SmtException {

  public SmtUserNotFoundException() {
  }

  public SmtUserNotFoundException(String message) {
    super(message);
  }
}