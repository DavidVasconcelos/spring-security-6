package com.udemy.springsecuritysection9.service;

import com.udemy.springsecuritysection9.model.Notices;
import java.util.List;

public interface NoticesService {

  List<Notices>  findAllActiveNotices();
}
