package com.sandbox.chapter11.schedule.services;

import com.google.common.collect.Lists;
import com.sandbox.chapter11.schedule.model.Car;
import com.sandbox.chapter11.schedule.repositories.CarCrudRepository;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andrii on 10.06.17.
 */
@Service("carService")
@Repository
@Transactional
public class CarServiceImpl implements CarService {

    final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    private CarCrudRepository carCrudRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Car> findAll() {
        return Lists.newArrayList(carCrudRepository.findAll());
    }

    @Override
    public Car save(Car car) {
        return carCrudRepository.save(car);
    }

    @Scheduled(cron = "0 * * * * *")
    @Override
    public void updateCarAgeJob() {
        List<Car> cars = findAll();
        DateTime currentDate = DateTime.now();
        logger.info("Car age update job started");
        for (Car car : cars) {
            int age =
                    Years.yearsBetween(car.getManufactureDate(), currentDate).getYears();
            car.setAge(age);
            save(car);
            logger.info("Car age update--- " + car);
        }
        logger.info("Car age update job completed successfully");
    }
}
