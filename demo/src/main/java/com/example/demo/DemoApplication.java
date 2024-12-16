package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
	@Info(description = "Una API de ejemplo para los alumnos de 2º DAM",
			version = "1.0",
			contact = @Contact(email = "delgado.hebru24@triana.salesianos.edu", name = "Bruno Delgado"),
			license = @License(name = "Mariscos Recio, el mar al mejor precio"),
			title = "API sobre productos"))
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
