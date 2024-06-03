package com.udemy.springsecuritysection13.controller;

import com.udemy.springsecuritysection13.model.Customer;
import com.udemy.springsecuritysection13.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  private final UserService service;

  public LoginController(final UserService service) {
    this.service = service;
  }

  @RequestMapping("/user")
  public Customer getUserDetailsAfterLogin(Authentication authentication) {
    return service.findByEmail(authentication.getName());
  }
}