package com.sandbox.chapter11.schedule.repositories;

import com.sandbox.chapter11.schedule.model.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by andrii on 10.06.17.
 */
public interface CarCrudRepository extends CrudRepository<Car, Long> {
}
