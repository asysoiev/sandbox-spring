package com.sandbox.chapter7.hibernate.model.ranking;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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
                        "left join fetch p.ranks r " +
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
    @OneToMany
    @JoinColumn(name = "SUBJECT_ID")
    private Set<Ranking> ranks;

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

    public Set<Ranking> getRanks() {
        return ranks;
    }

    public void setRanks(Set<Ranking> ranks) {
        this.ranks = ranks;
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
