package com.cacuware.hrms.mapper;

import com.cacuware.hrms.api.dto.PersonDto;
import com.cacuware.hrms.model.Person;
import com.cacuware.hrms.model.Status;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public static Person toEntity(PersonDto person) {
        return Person.builder()
                .address(person.getAddress())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .middleName(person.getMiddleName())
                .area(person.getArea())
                .birthday(person.getBirthday())
                .city(person.getCity())
                .gender(person.getGender())
                .status(Status.getByValue(person.getStatus()))
                .build();
    }

    public PersonDto toDto(Person person) {
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
                .status(person.getStatus().getValue())
                .build();
    }
}
