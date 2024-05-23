package com.udemy.springsecuritysection10.service;

import com.udemy.springsecuritysection10.model.AccountTransactions;
import java.util.List;

public interface BalanceService {

  List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(Integer id);

}
