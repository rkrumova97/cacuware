package com.cacuware.hrms.api;

import com.cacuware.hrms.api.dto.EmployeeDto;
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
@RequestMapping("/api/hrms")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public Employee findEmployee(@PathVariable("id") UUID id) {
        return employeeService.getOneById(id);
    }

    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(Pageable pageable) {
        List<Employee> employees = employeeService.findAllEmployee(pageable.getSort());
        return ResponseEntity.ok().body(employees);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> create(@RequestBody EmployeeDto employeeDto) throws URISyntaxException {
        Employee employee = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.created(new URI("/api/" + employee.getId()))
                .body(employee);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> update(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.updateEmployee(employeeDto);
        if (Objects.nonNull(employee)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(employee);
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping(value = "/employees/{uuid}")
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        employeeService.deleteEmployee(uuid);
        return ResponseEntity.noContent().build();
    }
}

