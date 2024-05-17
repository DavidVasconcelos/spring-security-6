package com.udemy.springsecuritysection7.service;

import com.udemy.springsecuritysection7.model.Notices;
import java.util.List;

public interface NoticesService {

  List<Notices>  findAllActiveNotices();
}
