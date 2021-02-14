package com.cacuware.warehouse.api;

import com.cacuware.warehouse.api.dto.CarDto;
import com.cacuware.warehouse.model.Car;
import com.cacuware.warehouse.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/warehouse/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/{id}")
    public Car findCar(@PathVariable("id") UUID id) {
        return carService.getOneById(id);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(Pageable pageable) {
        List<Car> people = carService.findAllCars(pageable.getSort());
        return ResponseEntity.ok().body(people);
    }

    @PostMapping
    public ResponseEntity<Car> create(@RequestBody CarDto carDto) throws URISyntaxException {
        Car car = carService.saveCar(carDto);
        return ResponseEntity.created(new URI("/api/" + car.getId()))
                .body(car);
    }

    @DeleteMapping(value = "/{uuid}")
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        carService.deleteCar(uuid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/archive")
    public ResponseEntity<List<Car>> archive() {
        List<Car> employees = carService.findAllDeletedCars();
        return ResponseEntity.ok().body(employees);
    }
}
