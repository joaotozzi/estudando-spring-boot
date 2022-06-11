package br.com.joaotozzi.estudandospringboot.model;

import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {

}
