package com.udemy.springsecuritysection8.service;

import com.udemy.springsecuritysection8.model.AccountTransactions;
import java.util.List;

public interface BalanceService {

  List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(Integer id);

}
