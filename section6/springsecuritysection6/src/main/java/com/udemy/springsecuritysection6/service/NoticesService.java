package com.udemy.springsecuritysection6.service;

import com.udemy.springsecuritysection6.model.Notices;
import java.util.List;

public interface NoticesService {

  List<Notices>  findAllActiveNotices();
}
