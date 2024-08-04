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

    public Pizza save(Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    public Pizza update(Pizza pizza){
        try {
            if (!pizzaRepository.existsById(pizza.getIdPizza()) || pizza.getIdPizza() == null){
                throw new RuntimeException("El id no es valido");
            }
            return pizzaRepository.save(pizza);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
