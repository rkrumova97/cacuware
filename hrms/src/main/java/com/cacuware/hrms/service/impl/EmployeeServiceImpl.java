package com.cacuware.hrms.service.impl;

import com.cacuware.hrms.api.dto.EmployeeDto;
import com.cacuware.hrms.mapper.EmployeeMapper;
import com.cacuware.hrms.model.Employee;
import com.cacuware.hrms.model.SecurityData;
import com.cacuware.hrms.repository.EmployeeRepository;
import com.cacuware.hrms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        return employeeRepository.save(EmployeeMapper.toEntity(employeeDto));
    }

    @Override
    public Employee getOneById(UUID uuid) {
        return employeeRepository.getOne(uuid);
    }

    @Override
    public void deleteEmployee(UUID uuid) {
        employeeRepository.delete(uuid);
    }

    @Override
    public List<Employee> findAllEmployee(Sort sort) {
        return employeeRepository.findAll(sort);
    }

    @Override
    public Employee updateEmployee(EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDto.getId());
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setEndDate(employeeDto.getEndDate());
            employee.setIsFired(employeeDto.getIsFired());
            employee.setJobNumber(employeeDto.getJobNumber());
            employee.setPerson(employeeDto.getPerson());
            employee.setSecurityData(employeeDto.getSecurityData());
            employee.setStartDate(employeeDto.getStartDate());
            employee.setVacationDays(employeeDto.getVacationDays());
            employee.setWorkingDays(employeeDto.getWorkingDays());
            employee.setWorkingHours(employeeDto.getWorkingHours());
            return employeeRepository.save(employee);
        } else return null;
    }
}
