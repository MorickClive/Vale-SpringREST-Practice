package com.mc.notetracker.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mc.notetracker.persistence.domain.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
