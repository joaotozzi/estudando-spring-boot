package br.com.joaotozzi.estudandospringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaotozzi.estudandospringboot.component.Droid;

@RestController
@RequestMapping("/droid")
public class DroidController {
	
	private final Droid droid;
	
	public DroidController(Droid droid){
		this.droid = droid;
	}
	
	@GetMapping
	Droid getDroid() {
		return droid;
	}
}
