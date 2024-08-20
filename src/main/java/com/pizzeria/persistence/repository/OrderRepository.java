package com.pizzeria.persistence.repository;

import com.pizzeria.persistence.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<Order, Integer> {

    List<Order> findAllByDateAfter(LocalDate date);
    List<Order> findAllByMethodIn(List<String> methods);

    @Query(value = "SELECT * FROM pizza_order WHERE id_customer = :idCustomer", nativeQuery = true)
    List<Order> findCustomerOrders(String idCustomer);

}
