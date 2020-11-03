package com.cacuware.hrms.api;

import com.cacuware.hrms.api.dto.EmployeeDto;
import com.cacuware.hrms.mapper.EmployeeMapper;
import com.cacuware.hrms.model.Education;
import com.cacuware.hrms.model.Employee;
import com.cacuware.hrms.model.JobType;
import com.cacuware.hrms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class EnumsController {

    @GetMapping("/jobs")
    public List<String> findJobs() {
        return JobType.getAllNames();
    }

    @GetMapping("/education")
    public List<String> findEducation() {
        return Education.getAllNames();
    }

}



