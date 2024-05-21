package com.udemy.springsecuritysection8.service;

import com.udemy.springsecuritysection8.model.Cards;
import java.util.List;

public interface CardsService {

  List<Cards> findByCustomerId(Integer id);

}
