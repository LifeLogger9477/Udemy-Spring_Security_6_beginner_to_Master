package com.eazybytes.repository;

import com.eazybytes.model.AccountTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-04-11
 */
@Repository
public interface AccountTransactionRepository
    extends CrudRepository<AccountTransactions, Long> {

  List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(
      int customerId
  );
}
