package com.pizzeria.persistence.repository;

import com.pizzeria.persistence.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {

    @Query("SELECT c FROM Customer c WHERE c.phoneNumber = :phone")
    Customer findByPhone(String phone);
}
