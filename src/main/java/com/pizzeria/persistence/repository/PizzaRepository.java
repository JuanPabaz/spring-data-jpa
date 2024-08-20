package com.pizzeria.persistence.repository;

import com.pizzeria.persistence.entity.Pizza;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<Pizza, Integer> {

    List<Pizza> findAllByAvailableTrueOrderByPrice();

    Optional<Pizza> findFirstByAvailableTrueAndNameIgnoreCase(String name);

    List<Pizza> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);

    List<Pizza> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
    List<Pizza> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(Double price);

    int countByVeganTrue();

}
