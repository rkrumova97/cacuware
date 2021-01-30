package com.cacuware.hrms.api;

import com.cacuware.hrms.api.dto.EmployeeDto;
import com.cacuware.hrms.api.dto.VacationDto;
import com.cacuware.hrms.mapper.EmployeeMapper;
import com.cacuware.hrms.model.Employee;
import com.cacuware.hrms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api/hrms/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public EmployeeDto findEmployee(@PathVariable("id") UUID id) {
        return EmployeeMapper.toDto(employeeService.getOneById(id));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return ResponseEntity.ok().body(employees);
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody EmployeeDto employeeDto) throws URISyntaxException {
        Employee employee = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.created(new URI("/api/" + employee.getId()))
                .body(employee);
    }

    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody EmployeeDto employeeDto) throws URISyntaxException {
        Employee employee = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.created(new URI("/api/" + employee.getId()))
                .body(employee);
    }

    @PutMapping("/vacation")
    public ResponseEntity<Employee> updateVacationDays(@RequestBody VacationDto vacationDto) throws URISyntaxException {
        Employee employee = employeeService.updateEmployee(vacationDto);
        return ResponseEntity.created(new URI("/api/" + employee.getId()))
                .body(employee);
    }

    @DeleteMapping(value = "/{uuid}")
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        employeeService.deleteEmployee(uuid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/fire/{uuid}")
    public ResponseEntity<Employee> fire(@PathVariable UUID uuid) {
        Employee employee = employeeService.fireEmployee(uuid);
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping(value = "/archive")
    public ResponseEntity<List<Employee>> archive() {
        List<Employee> employees = employeeService.findAllFiredEmployees();
        return ResponseEntity.ok().body(employees);
    }
}

