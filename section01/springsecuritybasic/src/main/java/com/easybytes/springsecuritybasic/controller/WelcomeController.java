package com.easybytes.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author : ms.Lee
 * date   : 2024-01-26
 */
@RestController
public class WelcomeController {

  @GetMapping (value = "/welcome")
  public String sayWelcome() {

    return "Welcome to Spring Application with Security.";
  }
}
