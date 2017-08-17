package com.sandbox.chapter7.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by andrii on 22.04.17.
 */
@Entity
@Table(name = "contact_tel_detail")
public class ContactTelDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;
    @Column(name = "TEL_TYPE")
    private String telType;
    @Column(name = "TEL_NUMBER")
    private String telNumber;
    @ManyToOne
    @JoinColumn(name = "CONTACT_ID")
    private Contact contact;

    public ContactTelDetail() {
    }

    public ContactTelDetail(String telType, String telNumber) {
        this.telType = telType;
        this.telNumber = telNumber;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTelType() {
        return this.telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "ContactTelDetail{" +
                "id=" + id +
                ", version=" + version +
                ", telType='" + telType + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", contact=" + contact +
                '}';
    }
}
