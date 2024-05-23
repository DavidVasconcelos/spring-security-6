package com.udemy.springsecuritysection10.service;

import com.udemy.springsecuritysection10.model.Cards;
import java.util.List;

public interface CardsService {

  List<Cards> findByCustomerId(Integer id);

}
