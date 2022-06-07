package br.com.joaotozzi.estudandospringboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaotozzi.estudandospringboot.model.Coffee;

@RestController
@RequestMapping("/coffees")
public class RestApiController {
	private List<Coffee> coffees = new ArrayList<>();

	public RestApiController() {
		coffees.addAll(List.of(new Coffee("Café Cafuso"), new Coffee("Café Carnielle"),
				new Coffee("Café Três Corações"), new Coffee("Café Moinho")));
	}

	@GetMapping
	Iterable<Coffee> getCoffees() {
		return coffees;
	}

	@GetMapping("/{id}")
	Optional<Coffee> getCoffeeById(@PathVariable String id) {
		for (Coffee c : coffees) {
			if (c.getId().equals(id)) {
				return Optional.of(c);
			}
		}

		return Optional.empty();
	}
	
	@PostMapping
	Coffee postCoffee(@RequestBody Coffee coffee){
		coffees.add(coffee);
		return coffee;
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
		int coffeeIndex = -1;
		
		for(Coffee c : coffees) {
			if(c.getId().equals(id)) {
				coffeeIndex = coffees.indexOf(c);
				coffees.set(coffeeIndex, coffee);
			}
		}
		
		return (coffeeIndex == -1) ? 
				new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) : 
				new ResponseEntity<>(coffee, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	void deleteCoffee(@PathVariable String id) {
		coffees.removeIf(c -> c.getId().equals(id));
	}
}
