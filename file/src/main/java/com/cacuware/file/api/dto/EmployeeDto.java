package com.cacuware.file.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private int number;
    private String name;
    private String egn;
    private String idCard;
    private String idAuthority;
    private String idYear;
    private String area;
    private String city;
    private String address;
    private String education;
    private Integer professionYearsOfLabour;
    private Integer professionMonthsOfLabour;
    private Integer professionDaysOfLabour;
    private Integer yearsOfLabour;
    private Integer monthsOfLabour;
    private Integer daysOfLabour;
    private String firstName;
    private String middleName;
    private String lastName;
    private String jobType;
    private String jobNumber;
    private String salary;
    private String workingHours;
    private String vacationDays;
    private LocalDate endDate;
}
