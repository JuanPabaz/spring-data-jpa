package com.pizzeria.controller;

import com.pizzeria.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getAll() throws Exception {
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/today")
    public ResponseEntity<?> getByDate() throws Exception {
        return ResponseEntity.ok(orderService.findByDate());
    }

    @GetMapping("/method")
    public ResponseEntity<?> getByMethod() throws Exception {
        return ResponseEntity.ok(orderService.getOutsideOrders());
    }

    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<?> getByCustomerId(@PathVariable(name = "idCustomer") String idCustomer) throws Exception {
        return ResponseEntity.ok(orderService.getCustomerOrders(idCustomer));
    }

    @GetMapping("/orderSummary/{idOrder}")
    public ResponseEntity<?> getOrderSummary(@PathVariable(name = "idOrder") Integer idOrder) throws Exception {
        return ResponseEntity.ok(orderService.findOrderSummary(idOrder));
    }

}
