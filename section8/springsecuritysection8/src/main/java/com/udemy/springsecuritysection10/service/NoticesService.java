package com.udemy.springsecuritysection10.service;

import com.udemy.springsecuritysection10.model.Notices;
import java.util.List;

public interface NoticesService {

  List<Notices>  findAllActiveNotices();
}
