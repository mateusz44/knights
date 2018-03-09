package com.springboot.demo.repository;

import com.springboot.demo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    public void createPerson(String name, int age) {
        Person person = new Person(name, age);
        em.persist(person);
    }

    public List<Person> getAllPerson() {
        return em.createQuery("FROM Person", Person.class).getResultList();
    }

    public List<Person> getAllPersonInGroup(int age) {
        return em.createQuery("FROM Person p where p.age<:age", Person.class)
                .setParameter("age", age)
                .getResultList();
    }

    public Person getPerson(String name) {
        return em.createQuery("FROM Person k where k.name=:name", Person.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<Person> getAllChefs() {
        return em.createQuery("FROM Person p WHERE p.chef is null", Person.class)
                .getResultList();
    }

    public List<Person> getAllChefsInGroup(int age) {
        return em.createQuery("FROM Person p where p.age<:age and p.chef is null", Person.class)
                .setParameter("age", age).setMaxResults(1).getResultList();
    }

    public void deletePerson(Integer id) {
        em.remove(id);
    }

    public void createPerson(Person person) {
        em.persist(person);
    }

    public Person getPersonById(Integer id) {
        return em.find(Person.class, id);
    }

    public void updatePerson(Person person) {
        em.merge(person);
    }
} 
