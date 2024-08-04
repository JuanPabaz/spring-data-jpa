package com.pizzeria.persistence.repository;

import com.pizzeria.persistence.entity.Order;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository extends ListCrudRepository<Order, Integer> {
}
