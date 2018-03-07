package repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import domain.Chef;
import domain.Chef;
import domain.Person;
@Repository
@Entity
public class ChefRepository {
	 
		@PersistenceContext
	    private EntityManager em;


	    @Transactional
	    public void createChef(String name, int age){
	    	Chef chef = new Chef(name, age);
	    	em.persist(chef);
	    }
	    public List<Chef> getAllChef() {

	        return  em.createQuery("from Chef", Chef.class).getResultList();
	    }

	    public List<Chef> getAllChefsInGroup(int age) {
	        return  em.createQuery("from Chef c where c.age<:age", Chef.class)
	        		  .setParameter("age", age).setMaxResults(1).getResultList();
	    }
	    public Chef getChef(String name) {

	    	Chef chefByName = em.createQuery("from Chef k where k.name=:name", Chef.class)
	                .setParameter("name", name).getSingleResult();

	        return  chefByName;
	    }
 
	    @Transactional
	    public void deleteChef(Integer id) {
	        em.remove(id);
	    }


	    public Chef getChefById(Integer id) {
	        return em.find(Chef.class, id);
	    }


	    @Transactional
	    public void updateChef(int id, Chef chef) {
	        em.merge(chef);
	    }

}
