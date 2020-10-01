package com.cacuware.hrms.mapper;

import com.cacuware.hrms.api.dto.PersonDto;
import com.cacuware.hrms.model.Person;
import com.cacuware.hrms.model.Status;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PersonMapper {
    public static Person toEntity(PersonDto personDto) {
        Person person =  Person.builder()
                .address(personDto.getAddress())
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .middleName(personDto.getMiddleName())
                .area(personDto.getArea())
                .birthday(personDto.getBirthday())
                .city(personDto.getCity())
                .gender(personDto.getGender())
                .status(Status.getByValue(personDto.getStatus()))
                .build();
        if(Objects.nonNull(personDto.getId())){
            person.setId(personDto.getId());
        }
        return person;
    }

    public static PersonDto toDto(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .address(person.getAddress())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .middleName(person.getMiddleName())
                .area(person.getArea())
                .birthday(person.getBirthday())
                .city(person.getCity())
                .gender(person.getGender())
                .build();
    }
}
