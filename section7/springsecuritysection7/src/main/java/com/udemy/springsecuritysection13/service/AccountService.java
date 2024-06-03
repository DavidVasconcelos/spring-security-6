package com.udemy.springsecuritysection13.service;

import com.udemy.springsecuritysection13.model.Accounts;

public interface AccountService {

  Accounts findByCustomerId(Integer id);
}
