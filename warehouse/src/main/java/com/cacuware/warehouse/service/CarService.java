package com.cacuware.warehouse.service;

import com.cacuware.warehouse.api.dto.CarDto;
import com.cacuware.warehouse.model.Car;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface CarService {
    Car saveCar(CarDto carDto);

    Car getOneById(UUID uuid);

    void deleteCar(UUID uuid);

    List<Car> findAllCars(Sort sort);

    List<Car> findAllDeletedCars();
}
