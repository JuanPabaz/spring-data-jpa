package com.pizzeria.service;

import com.pizzeria.persistence.entity.Order;
import com.pizzeria.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() throws Exception {
        try {
            return orderRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
