package com.easybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author : ms.Lee
 * date   : 2024-01-29
 */

// 사용자의 거래 내역 + 잔고 정보 반환
@RestController
public class BalanceController {


  @GetMapping (value = "/myBalance")
  public String getBalanceDetails() {

    return "Here are the balance Details from the DB";
  }
}
