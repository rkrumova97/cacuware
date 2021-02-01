package com.cacuware.warehouse.mapper;

import com.cacuware.warehouse.api.dto.CarDto;
import com.cacuware.warehouse.model.Car;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CarMapper {
    public static Car toEntity(CarDto carDto) {
        Car car =  Car.builder()
                .material(carDto.getMaterial())
                .type(carDto.getType())
                .brand(carDto.getBrand())
                .engineVolume(carDto.getEngineVolume())
                .examination(carDto.getExamination())
                .examinationExpiryDate(carDto.getExaminationExpiryDate())
                .fuel(carDto.getFuel())
                .insurance(carDto.getInsurance())
                .insuranceExpiryDate(carDto.getInsuranceExpiryDate())
                .kilometers(carDto.getKilometers())
                .norm(carDto.getNorm())
                .number(carDto.getNumber())
                .repair(carDto.getRepair())
                .repairDate(carDto.getRepairDate())
                .repairMoney(carDto.getRepairMoney())
                .vignette(carDto.getVignette())
                .vignetteExpiryDate(carDto.getVignetteExpiryDate())
                .build();
        if(Objects.nonNull(carDto.getId())){
            car.setId(carDto.getId());
        }
        return car;
    }

    public static CarDto toDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .material(car.getMaterial())
                .type(car.getType())
                .brand(car.getBrand())
                .engineVolume(car.getEngineVolume())
                .examination(car.getExamination())
                .examinationExpiryDate(car.getExaminationExpiryDate())
                .fuel(car.getFuel())
                .insurance(car.getInsurance())
                .insuranceExpiryDate(car.getInsuranceExpiryDate())
                .kilometers(car.getKilometers())
                .norm(car.getNorm())
                .number(car.getNumber())
                .repair(car.getRepair())
                .repairDate(car.getRepairDate())
                .repairMoney(car.getRepairMoney())
                .vignette(car.getVignette())
                .vignetteExpiryDate(car.getVignetteExpiryDate())
                .build();
    }
}
