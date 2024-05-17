package com.udemy.springsecuritysection7.service;

import com.udemy.springsecuritysection7.model.Loans;
import java.util.List;

public interface LoansService {

  List<Loans> findByCustomerIdOrderByStartDtDesc(Integer id);

}
