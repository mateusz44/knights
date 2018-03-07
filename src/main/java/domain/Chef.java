 package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;

@Entity
public class Chef{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int chef_id;
	public int getChef_id() {
		return chef_id;
	}
	public Chef(){}
	public void setChef_id(int chef_id) {
		this.chef_id = chef_id;
	}
    @ManyToMany
    @JoinTable(name="Chef_GuruTasks", 
               joinColumns = { @JoinColumn(name="chef_id") },
               inverseJoinColumns= { @JoinColumn(name="guru_tasks_id")})
    private List<GuruTasks> GuruTasks;
	
	public void setGuruTasks(List<GuruTasks> gurutasks){
		this.GuruTasks=gurutasks;
	}
	public List<GuruTasks> getGuruTasks(){
		return this.GuruTasks;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Person> getList() {
		return person;
	}
	public void setList(List<Person> person) {
		this.person = person;
	}
	private String name;
	private int age;
	@OneToMany(mappedBy="chef", cascade={CascadeType.PERSIST, CascadeType.MERGE, 
	CascadeType.DETACH, CascadeType.REFRESH})
	private List<Person> person;

	public Chef(String name, int age){
		this.name=name;
		this.age=age;
	}
	public void add(Person person1){
		if(person == null)
			person = new ArrayList<Person>();
		person.add(person1);
 
	}

	public List<Person> getPersons(){
		return person;
	}
	public void setPersons(List<Person> person){
		this.person=person;
	}
	public int getId(){
		return this.chef_id;
	}
	public void setId(int id){
		this.chef_id=id;
	}
}
 
