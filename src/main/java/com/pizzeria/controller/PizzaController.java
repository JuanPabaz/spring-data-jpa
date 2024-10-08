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
    public ResponseEntity<?> getAll(@RequestParam(name = "page", defaultValue = "0")Integer page,
                                    @RequestParam(name = "elements",defaultValue = "8")Integer elements) {
        return ResponseEntity.ok(pizzaService.getAll(page, elements));
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

    @GetMapping("/available")
    public ResponseEntity<?> getAllByAvailability(@RequestParam(name = "page", defaultValue = "0")Integer page,
                                                  @RequestParam(name = "elements",defaultValue = "8")Integer elements,
                                                  @RequestParam(defaultValue = "price")String sortBy,
                                                  @RequestParam(defaultValue = "ASC")String sortDirection) throws Exception {
        return ResponseEntity.ok(pizzaService.findAllByAvailability(page,elements,sortBy,sortDirection));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getAllByAvailabilityAndName(@PathVariable(name = "name")String name) throws Exception {
        return ResponseEntity.ok(pizzaService.findAllByAvailabilityAndName(name));
    }

    @GetMapping("/with/{ingredient}")
    public ResponseEntity<?> getWith(@PathVariable(name = "ingredient")String ingredient) throws Exception {
        return ResponseEntity.ok(pizzaService.getWith(ingredient));
    }

    @GetMapping("/without/{ingredient}")
    public ResponseEntity<?> getWithout(@PathVariable(name = "ingredient")String ingredient) throws Exception {
        return ResponseEntity.ok(pizzaService.getWithout(ingredient));
    }

    @GetMapping("/cheapest/{price}")
    public ResponseEntity<?> getCheapest(@PathVariable(name = "price")Double price) throws Exception {
        return ResponseEntity.ok(pizzaService.findCheapestPizza(price));
    }


}
