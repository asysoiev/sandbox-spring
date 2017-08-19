package com.sandbox.chapter7.hibernate.model.ranking;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by andrii on 18.08.17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Person.findAll",
                query = "select p " +
                        "from Person p "),
        @NamedQuery(name = "Person.findByName",
                query = "select p " +
                        "from Person p " +
                        "where p.name=:name"),
})
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;

    public Person() {
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
