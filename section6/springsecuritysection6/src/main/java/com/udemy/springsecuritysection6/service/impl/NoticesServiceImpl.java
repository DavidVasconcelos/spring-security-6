package com.udemy.springsecuritysection6.service.impl;

import com.udemy.springsecuritysection6.model.Notices;
import com.udemy.springsecuritysection6.repository.NoticeRepository;
import com.udemy.springsecuritysection6.service.NoticesService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NoticesServiceImpl implements NoticesService {

  private final NoticeRepository noticeRepository;

  public NoticesServiceImpl(final NoticeRepository noticeRepository) {
    this.noticeRepository = noticeRepository;
  }

  @Override
  public List<Notices> findAllActiveNotices() {
    return noticeRepository.findAllActiveNotices();
  }
}
