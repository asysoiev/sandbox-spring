package com.sandbox.chapter4.propertyeditors;

/**
 * @author Andrii Sysoiev
 */
public class Name {

    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("First name: %s; Last name: %s", firstName, lastName);
    }
}
