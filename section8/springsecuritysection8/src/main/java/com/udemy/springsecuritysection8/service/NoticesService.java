package com.udemy.springsecuritysection8.service;

import com.udemy.springsecuritysection8.model.Notices;
import java.util.List;

public interface NoticesService {

  List<Notices>  findAllActiveNotices();
}
