package br.com.joaotozzi.estudandospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import br.com.joaotozzi.estudandospringboot.component.Droid;

@SpringBootApplication
public class EstudandoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudandoSpringBootApplication.class, args);
	}
	
	@Bean
	@ConfigurationProperties(prefix = "droid")
	Droid createDroid() {
		return new Droid();
	}

}
