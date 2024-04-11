package com.eazybytes.repository;

import com.eazybytes.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * author : ms.Lee
 * date   : 2024-04-11
 */
@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {


}
