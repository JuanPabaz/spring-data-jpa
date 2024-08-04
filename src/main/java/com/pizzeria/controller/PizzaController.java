package com.pizzeria.controller;

import com.pizzeria.persistence.entity.Pizza;
import com.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(pizzaService.getAll());
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<?> getById(@PathVariable(name = "idPizza")Integer idPizza) throws Exception {
        return ResponseEntity.ok(pizzaService.getById(idPizza));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Pizza pizza){
        return ResponseEntity.ok(pizzaService.save(pizza));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Pizza pizza) throws Exception {
        return ResponseEntity.ok(pizzaService.update(pizza));
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "idPizza")Integer idPizza) throws Exception {
        pizzaService.delete(idPizza);
        return ResponseEntity.ok().build();
    }


}
