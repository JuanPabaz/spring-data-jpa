package com.pizzeria.service;

import com.pizzeria.persistence.entity.Order;
import com.pizzeria.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SITE = "S";

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() throws Exception {
        try {
            return orderRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Order> findByDate() throws Exception {
        try {
            LocalDate today = LocalDate.from(LocalDate.now().atTime(0, 0));
            return orderRepository.findAllByDateAfter(today);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Order> getOutsideOrders() throws Exception {
        try {
            List<String> methods = Arrays.asList(DELIVERY, CARRYOUT);
            return this.orderRepository.findAllByMethodIn(methods);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Order> getCustomerOrders(String idCustomer) throws Exception {
        try {
            return orderRepository.findCustomerOrders(idCustomer);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
