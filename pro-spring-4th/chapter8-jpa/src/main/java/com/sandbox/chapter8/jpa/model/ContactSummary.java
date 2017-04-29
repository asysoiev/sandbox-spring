package com.sandbox.chapter8.jpa.model;

import java.io.Serializable;

/**
 * Created by andrii on 29.04.17.
 */
public class ContactSummary implements Serializable {

    private final String name;
    private final String sername;
    private final String homePhone;

    public ContactSummary(String name, String sername, String homePhone) {
        this.name = name;
        this.sername = sername;
        this.homePhone = homePhone;
    }

    public String getName() {
        return name;
    }

    public String getSername() {
        return sername;
    }

    public String getHomePhone() {
        return homePhone;
    }

    @Override
    public String toString() {
        return "ContactSummary{" +
                "name='" + name + '\'' +
                ", sername='" + sername + '\'' +
                ", homePhone='" + homePhone + '\'' +
                '}';
    }
}
