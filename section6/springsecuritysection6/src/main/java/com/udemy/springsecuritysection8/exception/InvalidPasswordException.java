package com.udemy.springsecuritysection8.exception;

import java.io.Serial;

public class InvalidPasswordException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 7855735565488802857L;

  public InvalidPasswordException() {
    super("Invalid password");
  }
}