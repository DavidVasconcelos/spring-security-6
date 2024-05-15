package com.udemy.springsecuritysection6.service;

import com.udemy.springsecuritysection6.model.Loans;
import java.util.List;

public interface LoansService {

  List<Loans> findByCustomerIdOrderByStartDtDesc(Integer id);

}
