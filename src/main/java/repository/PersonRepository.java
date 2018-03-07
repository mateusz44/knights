 package repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import domain.Chef;
import domain.Person;

@Repository
@Entity
public class PersonRepository {
 
	@PersistenceContext
    private EntityManager em;

    @Transactional
    public void createPerson(String name,int age ) {

        Person person = new Person(name,age);

        em.persist(person);
 
    }
 
    public List<Person> getAllPerson() {

        return  em.createQuery("from Person", Person.class).getResultList();
    }
    public List<Person> getAllPersonInGroup(int age) {

        return  em.createQuery("from Person p where p.age<:age", Person.class)
        		  .setParameter("age", age).getResultList();
    }
    

    public Person getPerson(String name) {

    	Person personByName = em.createQuery("from Person k where k.name=:name", Person.class)
                .setParameter("name", name).getSingleResult();

        return  personByName;
    }

    @Transactional
    public void deletePerson(Integer id) {
        em.remove(id);
    }

    @Transactional
    public void createPerson(Person person, Chef chef) {
    
    	person.setChef(chef);
        em.persist(person);
    }

    public Person getPersonById(Integer id) {
        return em.find(Person.class, id);
    }


    @Transactional
    public void updatePerson(int id, Person person) {
        em.merge(person);
    }
 

} 
