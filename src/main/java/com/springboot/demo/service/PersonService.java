package com.springboot.demo.service;

import com.springboot.demo.entity.Person;
import com.springboot.demo.repository.GuruTasksRepository;
import com.springboot.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPersonById(int id) {
        return personRepository.getPersonById(id);
    }

    /*  @TODO nazwy parametrów  */
    public Person getPerson(String str) {
        return personRepository.getPerson(str);
    }

    public List<Person> getAllPerson() {
        return personRepository.getAllPerson();
    }

    /* @TODO dlaczego to jest przepisywane  ?  */
    public List<Person> getAllPersonInGroup(int age) {
        List<Person> persons = new ArrayList<>();
        for (Person person : personRepository.getAllPersonInGroup(age)) {
            persons.add(person);
        }
        return persons;
    }

    /* @TODO dlaczego to jest przepisywane do Setu + sprawdzane */
    public Set<Person> getAllChefsInGroup(int age) {
        Set<Person> chefs = new HashSet<>();
        for (Person chef : personRepository.getAllChefsInGroup(age)) {
            if (!chefs.contains(chef)) {
                chefs.add(chef);
                System.out.println(chefs.toString() + "::");
            }
        }
        return chefs;
    }

    public List<Person> getAllChefs() {
        return personRepository.getAllChefs();
    }

    public void updateChef(Person chef) {
        personRepository.updatePerson(chef);
    }
}
