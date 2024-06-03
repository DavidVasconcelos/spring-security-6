package com.udemy.springsecuritysection13.service.impl;

import com.udemy.springsecuritysection13.model.Customer;
import com.udemy.springsecuritysection13.model.Loans;
import com.udemy.springsecuritysection13.repository.LoansRepository;
import com.udemy.springsecuritysection13.service.LoansService;
import com.udemy.springsecuritysection13.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LoansServiceImpl implements LoansService {

  private final UserService userService;
  private final LoansRepository loansRepository;

  public LoansServiceImpl(final UserService userService, final LoansRepository loansRepository) {
    this.userService = userService;
    this.loansRepository = loansRepository;
  }

  @Override
  public List<Loans> findByCustomerEmailOrderByStartDtDesc(final String email) {
    final Customer customer = userService.findByEmail(email);
    return loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getId());
  }
}
