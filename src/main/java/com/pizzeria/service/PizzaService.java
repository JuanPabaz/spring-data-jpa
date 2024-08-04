package com.pizzeria.service;

import com.pizzeria.persistence.entity.Pizza;
import com.pizzeria.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> getAll(){
        return pizzaRepository.findAll();
    }

    public Pizza getById(Integer idPizza){
        return pizzaRepository.findById(idPizza).orElse(null);
    }
}
