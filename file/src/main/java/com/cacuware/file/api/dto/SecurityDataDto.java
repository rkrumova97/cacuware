package com.cacuware.file.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecurityDataDto {

    private UUID id;

    private Short egn;

    private Short idNumber;

    private LocalDate issuedDate;

    private String authority;

    private Integer yearsOfLabour;

    private Integer monthsOfLabour;

    private Integer daysOfLabour;

    private Float salary;

    private String IBAN;

    private String email;

    private Integer professionYearsOfLabour;

    private Integer professionMonthsOfLabour;

    private Integer professionDaysOfLabour;
}
