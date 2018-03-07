package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import controllers.PersonController;
import repository.PersonRepository; 
import service.PersonService;
import domain.Person;

@SpringBootApplication
@ComponentScan(basePackageClasses = {PersonController.class, PersonService.class, PersonRepository.class})

@EntityScan(basePackageClasses = Person.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
