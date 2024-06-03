package com.udemy.springsecuritysection13.controller;

import com.udemy.springsecuritysection13.model.Loans;
import com.udemy.springsecuritysection13.service.LoansService;
import java.util.List;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

  private final LoansService loanService;

  public LoansController(final LoansService loanService) {
    this.loanService = loanService;
  }

  @GetMapping("/myLoans")
  @PostAuthorize("hasRole('USER')")
  public List<Loans> getLoanDetails(@RequestParam String email) {
    return loanService.findByCustomerEmailOrderByStartDtDesc(email);
  }
}
