package com.udemy.springsecuritysection13.controller;

import com.udemy.springsecuritysection13.model.Notices;
import com.udemy.springsecuritysection13.service.NoticesService;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

  private final NoticesService noticesService;

  public NoticesController(final NoticesService noticesService) {
    this.noticesService = noticesService;
  }

  @GetMapping("/notices")
  public ResponseEntity<List<Notices>> getNotices() {
    List<Notices> notices = noticesService.findAllActiveNotices();
    if (notices != null) {
      return ResponseEntity.ok()
          .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
          .body(notices);
    } else {
      return null;
    }
  }
}
