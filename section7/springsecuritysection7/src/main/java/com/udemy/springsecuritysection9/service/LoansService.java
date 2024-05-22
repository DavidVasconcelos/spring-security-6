package com.udemy.springsecuritysection9.service;

import com.udemy.springsecuritysection9.model.Loans;
import java.util.List;

public interface LoansService {

  List<Loans> findByCustomerIdOrderByStartDtDesc(Integer id);

}
