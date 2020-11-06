package com.cacuware.file.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private UUID id;

    private LocalDate startDate;

    private LocalDate leavingDate;

    private LocalDate leavingNoticeSubmissionDate;

    private Integer vacationDays;

    private String jobNumber;

    private Integer workingHours;

    private Integer workingDays;

    private Boolean isFired;

    private PersonDto person;

    private SecurityDataDto securityData;

    private String education;

    private List<UUID> fileIds;

}
