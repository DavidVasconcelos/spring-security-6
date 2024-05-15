package com.udemy.springsecuritysection6.service;

import com.udemy.springsecuritysection6.model.Cards;
import java.util.List;

public interface CardsService {

  List<Cards> findByCustomerId(Integer id);

}
