package com.udemy.springsecuritysection9.service;

import com.udemy.springsecuritysection9.model.AccountTransactions;
import java.util.List;

public interface BalanceService {

  List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(Integer id);

}
