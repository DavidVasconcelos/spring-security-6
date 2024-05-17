package com.udemy.springsecuritysection7.service;

import com.udemy.springsecuritysection7.model.Accounts;

public interface AccountService {

  Accounts findByCustomerId(Integer id);
}
