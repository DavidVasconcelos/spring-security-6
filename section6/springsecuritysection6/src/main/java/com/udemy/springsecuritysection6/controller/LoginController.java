package com.udemy.springsecuritysection6.controller;

import com.udemy.springsecuritysection6.model.Customer;
import com.udemy.springsecuritysection6.service.UserService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  private final UserService service;

  public LoginController(final UserService service) {
    this.service = service;
  }

  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
    service.save(customer);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body("Given user details are successfully registered");
  }

  @RequestMapping("/user")
  public Customer getUserDetailsAfterLogin(Authentication authentication) {
    return service.findByEmail(authentication.getName());
  }
}