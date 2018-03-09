package com.springboot.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class GuruTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String descr;

    @ManyToMany(mappedBy = "guruTasks")
    private List<Person> person;

    public GuruTasks() {
    }

    public GuruTasks(String descr, List<Person> list) {
        this.descr = descr;
        this.person = list;
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

    public String toString() {
        return this.id + ":id" + this.descr + ":descr";
    }
}
