package com.udemy.springsecuritysection13.service;

import com.udemy.springsecuritysection13.model.Cards;
import java.util.List;

public interface CardsService {

  List<Cards> findByCustomerEmail(String email);

}
