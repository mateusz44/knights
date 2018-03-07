package repository;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import domain.Chef;
import domain.GuruTasks;
import domain.Person;

@Entity
@Repository
public class GuruTasksRepository {
	
	@PersistenceContext
    private EntityManager em;
	
    public List<GuruTasks> getGuruTasks(){
    	return em.createQuery("from GuruTasks").getResultList();
    }
    @Transactional
    public void createGuruTasks(String descr, List<Person> person, List<Chef> list){
    	em.persist(new GuruTasks(descr, person, list));
    }
}
