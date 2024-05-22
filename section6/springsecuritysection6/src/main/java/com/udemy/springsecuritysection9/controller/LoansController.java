package com.udemy.springsecuritysection9.controller;

import com.udemy.springsecuritysection9.model.Loans;
import com.udemy.springsecuritysection9.service.LoansService;
import java.util.List;
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
  public List<Loans> getLoanDetails(@RequestParam Integer id) {
    return loanService.findByCustomerIdOrderByStartDtDesc(id);
  }
}
