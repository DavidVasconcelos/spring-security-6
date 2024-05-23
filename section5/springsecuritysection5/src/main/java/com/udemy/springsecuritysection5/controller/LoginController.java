package com.udemy.springsecuritysection10.controller;

import com.udemy.springsecuritysection10.model.Customer;
import com.udemy.springsecuritysection10.service.EazyBankUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  private final EazyBankUserDetailsService service;

  public LoginController(final EazyBankUserDetailsService service) {
    this.service = service;
  }

  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
    service.save(customer);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body("Given user details are successfully registered");
  }
}