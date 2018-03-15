package com.springboot.demo.entity;


import javax.persistence.*;
import java.util.List;


@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int age;
    private String name;

    @ManyToMany
    @JoinTable(name = "PERSON_GURUTASKS",
            joinColumns = {@JoinColumn(name = "PERSON_ID")},
            inverseJoinColumns = {@JoinColumn(name = "GURUTASK_ID")})
    private List<GuruTasks> guruTasks;


    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "CHEF_ID")
    private Person chef;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void setChef(Person chef) {
        this.chef = chef;
    }

    public Person getChef() {
        return this.chef;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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

    public List<GuruTasks> getGuruTasks() {
        return guruTasks;
    }

    public void setGuruTasks(List<GuruTasks> guruTasks) {
        this.guruTasks = guruTasks;
    }

    @Override
    public String toString() {
        return "com.springboot.demo.entity.Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
 