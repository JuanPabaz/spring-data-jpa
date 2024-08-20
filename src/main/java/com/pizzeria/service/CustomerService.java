package com.pizzeria.service;

import com.pizzeria.persistence.entity.Customer;
import com.pizzeria.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findByPhone(String phone) throws Exception {
        try {
            return customerRepository.findByPhone(phone);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
