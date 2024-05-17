package com.udemy.springsecuritysection7.service;

import com.udemy.springsecuritysection7.model.Cards;
import java.util.List;

public interface CardsService {

  List<Cards> findByCustomerId(Integer id);

}
