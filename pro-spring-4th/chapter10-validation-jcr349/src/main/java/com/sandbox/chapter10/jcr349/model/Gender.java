package com.sandbox.chapter10.jcr349.model;

/**
 * @author Andrii Sysoiev
 */
public enum Gender {

    MALE("M"), FEMALE("F");
    private String code;

    private Gender(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }

}
