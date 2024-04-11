package com.eazybytes.controller;

import com.eazybytes.model.AccountTransactions;
import com.eazybytes.repository.AccountTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-01-29
 */

// 사용자의 거래 내역 + 잔고 정보 반환
@RestController
public class BalanceController {

  @Autowired
  private AccountTransactionRepository accountTransactionRepository;

  @GetMapping (value = "/myBalance")
  public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {

    List<AccountTransactions> accountTransactions =
        accountTransactionRepository
            .findByCustomerIdOrderByTransactionDtDesc( id );

    if (accountTransactions != null) {

      return accountTransactions;
    }
    else {

      return null;
    }
  }
  /*
  public String getBalanceDetails() {

    return "Here are the balance Details from the DB";
  }

   */
}
