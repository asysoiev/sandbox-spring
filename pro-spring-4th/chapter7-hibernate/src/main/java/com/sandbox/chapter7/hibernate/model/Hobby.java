package com.sandbox.chapter7.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by andrii on 22.04.17.
 */
@Entity
@Table(name = "hobby")
public class Hobby implements Serializable {
    @Id
    @Column(name = "HOBBY_ID")
    private String hobbyId;
    @ManyToMany
    @JoinTable(name = "contact_hobby_detail",
            joinColumns = @JoinColumn(name = "HOBBY_ID"),
            inverseJoinColumns = @JoinColumn(name = "CONTACT_ID"))
    private Set<Contact> contacts;

    public Hobby() {
        contacts = new HashSet<Contact>();
    }

    public String getHobbyId() {
        return this.hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String toString() {
        return "Hobby :" + getHobbyId();
    }

    public Set<Contact> getContacts() {
        return this.contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
}
