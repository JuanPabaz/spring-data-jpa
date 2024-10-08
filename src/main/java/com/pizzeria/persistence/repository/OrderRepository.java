package com.pizzeria.persistence.repository;

import com.pizzeria.persistence.entity.Order;
import com.pizzeria.persistence.projection.OrderSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<Order, Integer> {

    List<Order> findAllByDateAfter(LocalDate date);
    List<Order> findAllByMethodIn(List<String> methods);

    @Query(value = "SELECT * FROM pizza_order WHERE id_customer = :idCustomer", nativeQuery = true)
    List<Order> findCustomerOrders(String idCustomer);

    @Query(value =
            "SELECT po.id_order AS idOrder,cu.name AS customerName,po.date AS orderDate, po.total AS TotalPrice,GROUP_CONCAT(pi.name) AS pizzaName " +
            "FROM pizza_order po INNER JOIN customer cu ON po.id_customer = cu.id_customer " +
            "INNER JOIN order_item oi ON po.id_order = oi.id_order " +
            "INNER JOIN pizza pi ON oi.id_pizza = pi.id_pizza " +
            "WHERE po.id_order = :idOrder GROUP BY po.id_order,cu.name,po.date,po.total", nativeQuery = true)
    OrderSummary findOrderSummary(Integer idOrder);

}
