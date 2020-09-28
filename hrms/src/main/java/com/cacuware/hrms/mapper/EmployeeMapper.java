package com.cacuware.hrms.mapper;

import com.cacuware.hrms.api.dto.EmployeeDto;
import com.cacuware.hrms.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public static Employee toEntity(EmployeeDto employee) {
        return Employee.builder()
                .endDate(employee.getLeavingDate())
                .isFired(employee.getIsFired())
                .jobNumber(employee.getJobNumber())
                .person(employee.getPerson())
                .securityData(employee.getSecurityData())
                .startDate(employee.getStartDate())
                .vacationDays(employee.getVacationDays())
                .workingDays(employee.getWorkingDays())
                .workingHours(employee.getWorkingHours())
                .leavingNoticeSubmissionDate(employee.getLeavingNoticeSubmissionDate())
                .build();
    }

    public static EmployeeDto toDto(Employee employee) {
        return EmployeeDto.builder()
                .leavingDate(employee.getEndDate())
                .leavingNoticeSubmissionDate(employee.getLeavingNoticeSubmissionDate())
                .isFired(employee.getIsFired())
                .jobNumber(employee.getJobNumber())
                .person(employee.getPerson())
                .securityData(employee.getSecurityData())
                .startDate(employee.getStartDate())
                .vacationDays(employee.getVacationDays())
                .workingDays(employee.getWorkingDays())
                .workingHours(employee.getWorkingHours())
                .build();
    }
}
