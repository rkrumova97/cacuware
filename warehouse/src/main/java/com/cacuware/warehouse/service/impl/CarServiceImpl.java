package com.cacuware.warehouse.service.impl;

import com.cacuware.warehouse.api.dto.CarDto;
import com.cacuware.warehouse.mapper.CarMapper;
import com.cacuware.warehouse.model.Car;
import com.cacuware.warehouse.repository.CarRepository;
import com.cacuware.warehouse.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository repository;


    @Override
    public Car saveCar(CarDto carDto) {
        return repository.save(CarMapper.toEntity(carDto));
    }

    @Override
    public Car getOneById(UUID uuid) {
        return repository.getOne(uuid);
    }

    @Override
    public void deleteCar(UUID uuid) {
        Car car = getOneById(uuid);
        car.setDeleted(true);
        repository.save(car);
    }

    @Override
    public List<Car> findAllCars(Sort sort) {
        return repository.findAllByIsDeletedIsFalse();
    }

    @Override
    public List<Car> findAllDeletedCars() {
        return repository.findAllByIsDeletedIsTrue();
    }
}
