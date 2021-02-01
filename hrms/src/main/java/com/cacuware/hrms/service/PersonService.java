package com.cacuware.hrms.service;

import com.cacuware.hrms.api.dto.PersonDto;
import com.cacuware.hrms.api.dto.SecurityDataDto;
import com.cacuware.hrms.model.Person;
import com.cacuware.hrms.model.SecurityData;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    Person savePerson(PersonDto personDto);

    Person getOneById(UUID uuid);

    void deletePerson(UUID uuid);

    List<Person> findAllPerson(Sort sort);

    Person updatePerson(PersonDto personDto);
}
