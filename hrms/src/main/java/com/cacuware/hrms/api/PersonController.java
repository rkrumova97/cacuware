package com.cacuware.hrms.api;

import com.cacuware.hrms.api.dto.PersonDto;
import com.cacuware.hrms.model.Person;
import com.cacuware.hrms.service.PersonService;
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
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/persons/{id}")
    public Person findPerson(@PathVariable("id") UUID id) {
        return personService.getOneById(id);
    }

    @GetMapping(value = "/persons")
    public ResponseEntity<List<Person>> getAllPeople(Pageable pageable) {
        List<Person> people = personService.findAllPerson(pageable.getSort());
        return ResponseEntity.ok().body(people);
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> create(@RequestBody PersonDto personDto) throws URISyntaxException {
        Person person = personService.savePerson(personDto);
        return ResponseEntity.created(new URI("/api/" + person.getId()))
                .body(person);
    }

    @PutMapping("/persons")
    public ResponseEntity<Person> update(@RequestBody PersonDto personDto) {
        Person person = personService.updatePerson(personDto);
        if (Objects.nonNull(person)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(person);
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping(value = "/persons/{uuid}")
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        personService.deletePerson(uuid);
        return ResponseEntity.noContent().build();
    }
}
