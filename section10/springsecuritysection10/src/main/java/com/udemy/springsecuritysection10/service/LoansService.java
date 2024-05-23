package com.udemy.springsecuritysection10.service;

import com.udemy.springsecuritysection10.model.Loans;
import java.util.List;

public interface LoansService {

  List<Loans> findByCustomerIdOrderByStartDtDesc(Integer id);

}
