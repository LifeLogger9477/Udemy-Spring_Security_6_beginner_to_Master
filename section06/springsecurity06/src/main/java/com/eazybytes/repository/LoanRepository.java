package com.eazybytes.repository;

import com.eazybytes.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-04-11
 */
@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {

  List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}
