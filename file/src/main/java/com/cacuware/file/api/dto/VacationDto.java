package com.cacuware.file.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacationDto {
    private LocalDate startDate;
    private int vacationDays;
    private EmployeeDto employee;
}
