package com.udemy.springsecuritysection10.controller;

import com.udemy.springsecuritysection10.model.AccountTransactions;
import com.udemy.springsecuritysection10.service.BalanceService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

  private final BalanceService balanceService;

  public BalanceController(final BalanceService balanceService) {
    this.balanceService = balanceService;
  }

  @GetMapping("/myBalance")
  public List<AccountTransactions> getBalanceDetails(@RequestParam Integer id) {
    return balanceService.findByCustomerIdOrderByTransactionDtDesc(id);
  }
}
