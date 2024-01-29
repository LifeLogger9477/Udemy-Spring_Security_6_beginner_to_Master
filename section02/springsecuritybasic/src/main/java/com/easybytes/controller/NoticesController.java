package com.easybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author : ms.Lee
 * date   : 2024-01-29
 */
@RestController
public class NoticesController {

  @GetMapping (value = "/notices")
  public String getNotices() {

    return "Here are the notices details from the DB";
  }
}
