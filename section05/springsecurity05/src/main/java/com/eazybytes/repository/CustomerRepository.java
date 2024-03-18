package com.eazybytes.repository;

import com.eazybytes.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-01-31
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByEmail(String email);
}
