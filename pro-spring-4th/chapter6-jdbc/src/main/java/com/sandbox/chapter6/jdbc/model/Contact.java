package com.sandbox.chapter6.jdbc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by andrii on 17.04.17.
 */
public class Contact implements Serializable {

    private final List<ContactTelDetail> telDetails = new ArrayList<>();
    private long id;
    private String firstName;
    private String lastName;
    private Date birthDate;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<ContactTelDetail> getTelDetails() {
        return telDetails;
    }

    public void addTelDetails(List<ContactTelDetail> telDetails) {
        if (telDetails != null) {
            this.telDetails.addAll(telDetails);
        }
    }

    public void addTelDetail(ContactTelDetail detail) {
        this.telDetails.add(detail);
    }
}
