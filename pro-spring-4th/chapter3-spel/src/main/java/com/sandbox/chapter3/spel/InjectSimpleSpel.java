package com.sandbox.chapter3.spel;

/**
 * @author Andrii Sysoiev
 */
public interface InjectSimpleSpel {

    String getName();

    int getAge();

    float getHeight();

    boolean isProgrammer();

    Long getAgeInSeconds();

    default String renderInfo() {
        return "Name: " + getName() + "\n"
                + "Age: " + getAge() + "\n"
                + "Age in Seconds: " + getAgeInSeconds() + "\n"
                + "Height: " + getHeight() + "\n"
                + "Is Programmer?: " + isProgrammer();
    }

}
