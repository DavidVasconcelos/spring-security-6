package com.udemy.springsecuritysection8.service;

import com.udemy.springsecuritysection8.model.Loans;
import java.util.List;

public interface LoansService {

  List<Loans> findByCustomerIdOrderByStartDtDesc(Integer id);

}
