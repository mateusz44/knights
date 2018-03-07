package domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class GuruTasks {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String descr;
	
	public GuruTasks(){}
	
	@ManyToMany(mappedBy="GuruTasks")
	private List<Person> person;
	
	@ManyToMany(mappedBy="GuruTasks")
	private List<Chef> chef;
	
	public void setChef(List<Chef> chef){
		this.chef=chef;
	}
	
	public List<Chef> getChef(){
		return this.chef;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}
	public GuruTasks(String descr, List<Person> list, List<Chef> list2){
		this.descr=descr;
		this.person=list;
 		this.chef=list2;
	}
	public String toString(){
		return this.id+":id"+this.descr+":descr";
	}
}
