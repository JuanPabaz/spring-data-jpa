package com.pizzeria.persistence.repository;

import com.pizzeria.persistence.entity.Pizza;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<Pizza, Integer> {

    List<Pizza> findAllByAvailableTrueOrderByPrice();
    Pizza findAllByAvailableTrueAndNameIgnoreCase(String name);

}
