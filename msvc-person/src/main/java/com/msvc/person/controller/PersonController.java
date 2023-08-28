package com.msvc.person.controller;

import com.msvc.person.entity.PersonEntity;
import com.msvc.person.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private IPersonService iPersonService;

    @PostMapping
    public ResponseEntity<PersonEntity> addPerson(@Valid @RequestBody PersonEntity person) {
        PersonEntity personEntity = iPersonService.savePerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(personEntity);
    }

    @GetMapping
    public ResponseEntity<List<PersonEntity>> getPeople() {
        List<PersonEntity> people = iPersonService.getPeople();
        return ResponseEntity.ok(people);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonEntity> getPersonById(@PathVariable String person) {
        PersonEntity personEntity = iPersonService.getPerson(person);
        return ResponseEntity.ok(personEntity);
    }
}
