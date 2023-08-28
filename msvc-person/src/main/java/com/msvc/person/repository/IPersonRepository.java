package com.msvc.person.repository;

import com.msvc.person.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<PersonEntity, String> {
}
