package com.cacuware.hrms.service;

import com.cacuware.hrms.api.dto.EmployeeDto;
import com.cacuware.hrms.api.dto.VacationDto;
import com.cacuware.hrms.model.Employee;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    Employee saveEmployee(EmployeeDto EmployeeDto);

    Employee getOneById(UUID uuid);

    void deleteEmployee(UUID uuid);

    List<Employee> findAllEmployees();

    List<Employee> findAllFiredEmployees();

    Employee updateEmployee(VacationDto vacationDto);

    Employee fireEmployee(UUID id);
}

