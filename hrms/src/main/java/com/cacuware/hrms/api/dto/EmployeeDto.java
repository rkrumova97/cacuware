package com.cacuware.hrms.api.dto;

import com.cacuware.hrms.model.JobType;
import com.cacuware.hrms.model.Person;
import com.cacuware.hrms.model.SecurityData;
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
public class EmployeeDto {

    private UUID id;

    private LocalDate startDate;

    private LocalDate leavingDate;

    private LocalDate leavingNoticeSubmissionDate;

    private Integer vacationDays;

    private JobType jobNumber;

    private Integer workingHours;

    private Integer workingDays;

    private Boolean isFired;

    private Person person;

    private SecurityData securityData;

    private String education;

}
