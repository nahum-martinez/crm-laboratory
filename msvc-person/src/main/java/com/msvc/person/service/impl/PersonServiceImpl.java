package com.msvc.person.service.impl;

import com.msvc.person.entity.PersonEntity;
import com.msvc.person.exception.ResourceNotFoundException;
import com.msvc.person.repository.IPersonRepository;
import com.msvc.person.service.IPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonServiceImpl implements IPersonService {
    private final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
    @Autowired
    private IPersonRepository personRepository;

    @Override
    public PersonEntity savePerson(PersonEntity person) {
        String randomPersonId = UUID.randomUUID().toString();
        person.setIdPerson(randomPersonId);
        return personRepository.save(person);
    }

    @Override
    public List<PersonEntity> getPeople() {
        return personRepository.findAll();
    }

    @Override
    public PersonEntity getPerson(String personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with ID: " + personId));
    }
}
