package com.springboot.demo.repository;

import com.springboot.demo.entity.GuruTasks;
import com.springboot.demo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class GuruTasksRepository {
	
	@PersistenceContext
    private EntityManager em;
	
    public List<GuruTasks> getGuruTasks(){
    	return em.createQuery("FROM GuruTasks").getResultList();
    }
    @Transactional
    public void createGuruTasks(String descr, List<Person> person, List<Person> list){
    	em.persist(new GuruTasks(descr, person));
    }
}
