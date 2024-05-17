package com.udemy.springsecuritysection7.controller;

import com.udemy.springsecuritysection7.model.Accounts;
import com.udemy.springsecuritysection7.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  private final AccountService accountService;

  public AccountController(final AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/myAccount")
  public Accounts getAccountDetail(@RequestParam Integer id) {
    return accountService.findByCustomerId(id);
  }
}
