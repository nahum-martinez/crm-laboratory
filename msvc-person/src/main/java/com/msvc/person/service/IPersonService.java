package com.msvc.person.service;

import com.msvc.person.entity.PersonEntity;

import java.util.List;

public interface IPersonService {
    PersonEntity savePerson(PersonEntity person);

    List<PersonEntity> getPeople();

    PersonEntity getPerson(String personId);
}
