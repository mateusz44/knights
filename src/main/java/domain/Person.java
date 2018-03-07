package domain;

 
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;



@Entity
public class Person {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
  
    @ManyToMany
    @JoinTable(name="Person_GuruTasks", 
               joinColumns = { @JoinColumn(name="Person_Id") },
               inverseJoinColumns= { @JoinColumn(name="GuruTasks_Id")})
    private List<GuruTasks> GuruTasks;
    
    
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="chef_id")
    private Chef chef;
    
    public void setChef(Chef chef){
    	this.chef = chef;
    }

    public Chef getChef(){
    	return this.chef;
    }
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	private int age;
    private String name;
   

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person() {

	}

	public Person(String name, int age) {
		this.name = name;
		this.age=age;
	}
	 public String toString(){
		 return this.name+"name"+this.id;
	 }
}
 