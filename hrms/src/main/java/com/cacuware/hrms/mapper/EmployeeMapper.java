package com.cacuware.hrms.mapper;

import com.cacuware.hrms.api.dto.EmployeeDto;
import com.cacuware.hrms.model.Education;
import com.cacuware.hrms.model.Employee;
import com.cacuware.hrms.model.JobType;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EmployeeMapper {

    public static Employee toEntity(EmployeeDto employeeDto) {
        Employee employee = Employee.builder()
                .endDate(employeeDto.getLeavingDate())
                .isFired(employeeDto.getIsFired())
                .startDate(employeeDto.getStartDate())
                .vacationDays(employeeDto.getVacationDays())
                .workingDays(employeeDto.getWorkingDays())
                .workingHours(employeeDto.getWorkingHours())
                .leavingNoticeSubmissionDate(employeeDto.getLeavingNoticeSubmissionDate())
                .build();
        if (Objects.nonNull(employeeDto.getId())) {
            employee.setId(employeeDto.getId());
        }
        if (Objects.nonNull(JobType.getByText(employeeDto.getJobNumber()))) {
            employee.setJobNumber(JobType.getByText(employeeDto.getJobNumber()));
        } else {
            employee.setJobNumber(JobType.valueOf(employeeDto.getJobNumber()));
        }
        if (Objects.nonNull(Education.getByText(employeeDto.getEducation()))) {
            employee.setEducation(Education.getByText(employeeDto.getEducation()));
        } else {
            employee.setEducation(Education.valueOf(employeeDto.getEducation()));
        }
        if (Objects.nonNull(employeeDto.getSecurityData())) {
            employee.setSecurityData(SecurityDataMapper.toEntity(employeeDto.getSecurityData()));
        }
        if (Objects.nonNull(employeeDto.getFileIds())) {
            employee.setFileIDs(employeeDto.getFileIds());
        }
        return employee;
    }

    public static EmployeeDto toDto(Employee employee) {
        return EmployeeDto.builder()
                .leavingDate(employee.getEndDate())
                .leavingNoticeSubmissionDate(employee.getLeavingNoticeSubmissionDate())
                .isFired(employee.getIsFired())
                .jobNumber(employee.getJobNumber().getText())
                .education(employee.getEducation().getText())
                .person(PersonMapper.toDto(employee.getPerson()))
                .securityData(SecurityDataMapper.toDto(employee.getSecurityData()))
                .startDate(employee.getStartDate())
                .vacationDays(employee.getVacationDays())
                .workingDays(employee.getWorkingDays())
                .workingHours(employee.getWorkingHours())
                .fileIds(employee.getFileIDs())
                .build();
    }
}
