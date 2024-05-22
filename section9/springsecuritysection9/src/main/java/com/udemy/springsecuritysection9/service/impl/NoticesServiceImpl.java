package com.udemy.springsecuritysection9.service.impl;

import com.udemy.springsecuritysection9.model.Notices;
import com.udemy.springsecuritysection9.repository.NoticeRepository;
import com.udemy.springsecuritysection9.service.NoticesService;
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
