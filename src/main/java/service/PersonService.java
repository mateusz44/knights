package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.ChefRepository;
import repository.GuruTasksRepository;
import repository.PersonRepository;
 
import domain.Chef;
import domain.Person;

@Service
@Entity
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	@Autowired
	ChefRepository chefRepository;
	@Autowired
	GuruTasksRepository guruTasksRepository;
    @PostConstruct
    public void build() {
    	personRepository.createPerson(new Person("Andrzej", 34), new Chef("Johny", 27));
    	personRepository.createPerson("Mateusz", 34) ;
    	personRepository.createPerson("tomasz", 24) ;
    	personRepository.createPerson(new Person("Staszek", 34), new Chef("Emil", 67));
    	personRepository.createPerson("Weronika", 34);
    	System.out.println(  chefRepository.getChef("Johny") +"{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{" );
    	getPerson("Mateusz").setChef(chefRepository.getChef("Johny"));
    	getPerson("tomasz").setChef(chefRepository.getChef("Johny")); 
    	getPerson("Weronika").setChef(chefRepository.getChef("Emil"));
    	guruTasksRepository.createGuruTasks("Sklony", getAllPersonInGroup(33), chefRepository.getAllChefsInGroup(33));
    	guruTasksRepository.createGuruTasks("Kwiat lotosu", getAllPersonInGroup(33), chefRepository.getAllChefsInGroup(33));
    }
    public Person getPersonById(int id){
    	return personRepository.getPersonById(id);
    }
    public Person getPerson(String str){
    	return personRepository.getPerson(str);
    }
    public List<Person> getAllPerson(){
    	return personRepository.getAllPerson();
    }
    public List<Person> getAllPersonInGroup(int age){
    	List<Person> persons = new ArrayList<Person>();
    	for(Person person : personRepository.getAllPersonInGroup(age)){
    		persons.add(person);
    	}
    	return persons;
    }
    public Set<Chef> getAllChefsInGroup(int age){
    	String name="";
    	Set<Chef> chefs = new HashSet<Chef>();
    	for(Chef chef : chefRepository.getAllChefsInGroup(age)){
    		if(!chefs.contains(chef)){
    			chefs.add(chef);
    			System.out.println(chefs.toString()+"::");
    		}
    	}
		return chefs;
    }

    public List<Chef> getAllChefs(int flag){
  			Chef chef = null;
			List<Chef> listChefs = new ArrayList<Chef>();
			List<Person> persons = getAllPerson();
			String name="";
			for(Person person : persons){ 
				name=person.getChef().getName();
			}
			for(Person person : persons){
				if(person.getChef().getName().equals(name))
					listChefs.add(new Chef("-", 0));
				else
					listChefs.add(person.getChef());
				name=person.getChef().getName();
			}
			return listChefs;
    }
    
    public void updateChef(int id, Chef chef) {
        chefRepository.updateChef(id, chef);
    }
 
}
