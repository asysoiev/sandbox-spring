package com.sandbox.chapter4.profiles.model;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
public class FoodProviderImpl implements FoodProvider {

    private final List<Food> lunch;

    public FoodProviderImpl(List<Food> lunch) {
        this.lunch = lunch;
    }

    @Override
    public List<Food> getLunch() {
        return lunch;
    }
}
