package com.cacuware.hrms.service.impl;

import com.cacuware.hrms.api.dto.PersonDto;
import com.cacuware.hrms.mapper.PersonMapper;
import com.cacuware.hrms.model.Person;
import com.cacuware.hrms.model.Status;
import com.cacuware.hrms.repository.PersonRepository;
import com.cacuware.hrms.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(PersonDto personDto) {
        return personRepository.save(PersonMapper.toEntity(personDto));
    }

    @Override
    public Person getOneById(UUID uuid) {
        return personRepository.getOne(uuid);
    }

    @Override
    public void deletePerson(UUID uuid) {
        personRepository.delete(uuid);
    }

    @Override
    public List<Person> findAllPerson(Sort sort) {
        return personRepository.findAll(sort);
    }

    @Override
    public Person updatePerson(PersonDto personDto) {
        Optional<Person> optionalPerson = personRepository.findById(personDto.getId());
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setAddress(personDto.getAddress());
            person.setArea(personDto.getArea());
            person.setBirthday(personDto.getBirthday());
            person.setCity(personDto.getCity());
            person.setFirstName(personDto.getFirstName());
            person.setMiddleName(personDto.getMiddleName());
            person.setLastName(personDto.getLastName());
            person.setGender(personDto.getGender());
            person.setStatus(Status.getByValue(personDto.getStatus()));
            return personRepository.save(person);
        } else return null;
    }
}
