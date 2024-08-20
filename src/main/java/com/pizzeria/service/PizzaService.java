package com.pizzeria.service;

import com.pizzeria.persistence.entity.Pizza;
import com.pizzeria.persistence.repository.PizzaPagSortRepository;
import com.pizzeria.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PizzaPagSortRepository pizzaPagSortRepository;

    public Page<Pizza> getAll(int page, int elements) {
        Pageable pageable = PageRequest.of(page, elements);
        return pizzaPagSortRepository.findAll(pageable);
    }

    public Pizza getById(Integer idPizza) throws Exception {
        try {
            return pizzaRepository.findById(idPizza).orElse(null);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public Pizza save(Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    public Pizza update(Pizza pizza) throws Exception {
        try {
            if (!pizzaRepository.existsById(pizza.getIdPizza()) || pizza.getIdPizza() == null){
                throw new RuntimeException("El id no es valido");
            }
            return pizzaRepository.save(pizza);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public void delete(Integer idPizza) throws Exception {
        try {
            pizzaRepository.deleteById(idPizza);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Page<Pizza> findAllByAvailability(int page, int elements, String sortBy, String sortDirection) throws Exception {
        try {
            Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
            Pageable pageable = PageRequest.of(page, elements, sort);
           return pizzaPagSortRepository.findByAvailableTrue(pageable);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Pizza findAllByAvailabilityAndName(String name) throws Exception {
        try {
            return pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElseThrow(() -> new Exception("La pizza no existe"));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Pizza> getWith(String description) throws Exception {
        try {
            return pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(description);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Pizza> getWithout(String description) throws Exception {
        try {
            return pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(description);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Pizza> findCheapestPizza(Double price) throws Exception {
        try {
            return pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
