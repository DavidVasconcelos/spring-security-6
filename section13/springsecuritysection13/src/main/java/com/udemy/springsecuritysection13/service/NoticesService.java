package com.udemy.springsecuritysection13.service;

import com.udemy.springsecuritysection13.model.Notices;
import java.util.List;

public interface NoticesService {

  List<Notices>  findAllActiveNotices();
}
