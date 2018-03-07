package com.springboot.demo;
 

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;

import domain.Person;
 
 
@Scope("singleton")
public class Starter implements CommandLineRunner {

 
    public void run(String... strings) throws Exception {
  
    }
}