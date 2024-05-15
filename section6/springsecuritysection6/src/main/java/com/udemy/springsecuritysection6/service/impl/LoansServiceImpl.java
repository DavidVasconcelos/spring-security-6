package com.udemy.springsecuritysection6.service.impl;

import com.udemy.springsecuritysection6.model.Loans;
import com.udemy.springsecuritysection6.repository.LoansRepository;
import com.udemy.springsecuritysection6.service.LoansService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LoansServiceImpl implements LoansService {

  private final LoansRepository loansRepository;

  public LoansServiceImpl(final LoansRepository loansRepository) {
    this.loansRepository = loansRepository;
  }

  @Override
  public List<Loans> findByCustomerIdOrderByStartDtDesc(final Integer id) {
    return loansRepository.findByCustomerIdOrderByStartDtDesc(id);
  }
}
