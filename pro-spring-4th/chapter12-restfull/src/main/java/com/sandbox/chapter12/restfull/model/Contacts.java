package com.sandbox.chapter12.restfull.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by andrii on 08.07.17.
 */
public class Contacts implements Serializable {

    private List<Contact> contacts;

    public Contacts() {
    }

    public Contacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
