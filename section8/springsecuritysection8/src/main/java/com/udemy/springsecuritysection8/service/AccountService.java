package com.udemy.springsecuritysection8.service;

import com.udemy.springsecuritysection8.model.Accounts;

public interface AccountService {

  Accounts findByCustomerId(Integer id);
}
