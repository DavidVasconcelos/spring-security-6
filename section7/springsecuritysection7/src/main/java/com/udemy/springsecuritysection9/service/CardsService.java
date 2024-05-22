package com.udemy.springsecuritysection9.service;

import com.udemy.springsecuritysection9.model.Cards;
import java.util.List;

public interface CardsService {

  List<Cards> findByCustomerId(Integer id);

}
