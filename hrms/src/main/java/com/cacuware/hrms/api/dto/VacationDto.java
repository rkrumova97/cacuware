package com.cacuware.hrms.api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VacationDto {
    private LocalDate startDate;
    private int vacationDays;
    private EmployeeDto employee;
}
