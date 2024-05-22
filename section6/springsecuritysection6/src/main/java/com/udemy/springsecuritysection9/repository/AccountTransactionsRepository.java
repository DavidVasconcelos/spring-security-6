package com.udemy.springsecuritysection9.repository;

import com.udemy.springsecuritysection9.model.AccountTransactions;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, Integer> {

  List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(Integer customerId);

}