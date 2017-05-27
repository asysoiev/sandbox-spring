package com.sandbox.chapter10.jcr349.model;

/**
 * @author Andrii Sysoiev
 */
public enum CustomerType {

    INDIVIDUAL("I"), CORPORATE("C");
    private String code;

    private CustomerType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CustomerType{" +
                "code='" + code + '\'' +
                '}';
    }
}
