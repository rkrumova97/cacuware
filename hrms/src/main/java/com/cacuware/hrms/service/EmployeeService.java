package com.cacuware.hrms.service;

import com.cacuware.hrms.api.dto.EmployeeDto;
import com.cacuware.hrms.model.Employee;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    public Employee saveEmployee(EmployeeDto EmployeeDto);

    Employee getOneById(UUID uuid);

    public void deleteEmployee(UUID uuid);

    List<Employee> findAllEmployees();

    List<Employee> findAllFiredEmployees();

    Employee updateEmployee(EmployeeDto EmployeeDto);

    Employee fireEmployee(UUID id);
}

