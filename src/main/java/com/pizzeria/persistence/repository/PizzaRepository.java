package com.pizzeria.persistence.repository;

import com.pizzeria.persistence.entity.Pizza;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaRepository extends ListCrudRepository<Pizza, Integer> {
}
