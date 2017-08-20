package com.sandbox.chapter7.hibernate.model.ranking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by andrii on 18.08.17.
 */
@Entity
public class Skill implements Serializable {

    @Id
    @Column(unique = true, nullable = false)
    private String name;

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                '}';
    }
}
