package com.cacuware.hrms.service.impl;

import com.cacuware.hrms.api.dto.EmployeeDto;
import com.cacuware.hrms.api.dto.VacationDto;
import com.cacuware.hrms.mapper.EmployeeMapper;
import com.cacuware.hrms.model.Employee;
import com.cacuware.hrms.repository.EmployeeRepository;
import com.cacuware.hrms.service.EmployeeService;
import com.cacuware.hrms.service.PersonService;
import com.cacuware.hrms.service.SecurityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private SecurityDataService securityDataService;

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.toEntity(employeeDto);
        if (Objects.nonNull(employeeDto.getPerson())) {
            employee.setPerson(personService.getOneById(employeeDto.getPerson().getId()));
        }
        return employeeRepository.save(employee);
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
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAllByIsFiredFalseOrIsFiredIsNull();
    }

    @Override
    public List<Employee> findAllFiredEmployees() {
        return employeeRepository.findAllByIsFiredTrue();
    }

    @Override
    public Employee updateEmployee(VacationDto vacationDto) {
        EmployeeDto employeeDto = vacationDto.getEmployee();
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDto.getId());
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            int days = employee.getVacationDays() - vacationDto.getVacationDays();
            employee.setVacationDays(days);
            return employeeRepository.save(employee);
        } else return null;
    }

    @Override
    public Employee fireEmployee(UUID id) {
        Employee employee = getOneById(id);
        employee.setIsFired(true);
        employee.setEndDate(LocalDate.now());
        return employeeRepository.save(employee);
    }
}
