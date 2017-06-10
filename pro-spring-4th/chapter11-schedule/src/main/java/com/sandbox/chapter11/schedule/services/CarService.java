package com.sandbox.chapter11.schedule.services;

import com.sandbox.chapter11.schedule.model.Car;

import java.util.List;

/**
 * Created by andrii on 10.06.17.
 */
public interface CarService {

    List<Car> findAll();

    Car save(Car car);

    void updateCarAgeJob();

}
