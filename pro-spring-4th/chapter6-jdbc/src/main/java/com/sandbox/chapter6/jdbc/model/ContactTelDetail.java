package com.sandbox.chapter6.jdbc.model;

import java.io.Serializable;

/**
 * Created by andrii on 17.04.17.
 */
public class ContactTelDetail implements Serializable {

    private long id;
    private long contactId;
    private String telType;
    private String telNumber;

    @Override
    public String toString() {
        return "ContactTelDetail{" +
                "id=" + id +
                ", contactId=" + contactId +
                ", telType='" + telType + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
