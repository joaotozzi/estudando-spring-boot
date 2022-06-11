package br.com.joaotozzi.estudandospringboot.model;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class DataLoader {
	private final CoffeeRepository coffeeRepository;
	
	public DataLoader(CoffeeRepository coffeRepository) {
		this.coffeeRepository = coffeRepository;
	}
	
	@PostConstruct
	private void loadData() {
		coffeeRepository.saveAll(List.of(
				new Coffee("Café Cafuso"), 
				new Coffee("Café Carnielle"),
				new Coffee("Café Três Corações"), 
				new Coffee("Café Moinho")
		));
	}
}
