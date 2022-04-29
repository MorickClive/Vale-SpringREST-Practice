package com.mc.notetracker.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.notetracker.persistence.domain.Person;
import com.mc.notetracker.persistence.dto.PersonDTO;
import com.mc.notetracker.persistence.repos.PersonRepo;
import com.mc.notetracker.rest.CRUDOptions;
import com.mc.notetracker.util.ModelUtility;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class PersonService implements CRUDOptions<Person, PersonDTO> {
	
	private ModelMapper parser;
	private PersonRepo repo;
	
	private PersonDTO mapToDTO(Person obj) {
		return this.parser.map(obj, PersonDTO.class);
	}
	private Person mapToModel(PersonDTO obj) {
		return this.parser.map(obj, Person.class);
	}
	
	@Autowired
	public PersonService(PersonRepo repo, ModelMapper mapper, ModelUtility util) {
		super();
		this.repo = repo;
		this.parser = mapper;
	}

	@Override
	public PersonDTO create(Person model) {
		return mapToDTO(repo.save(model));
	}

	@Override
	public Optional<PersonDTO> read(Integer id) {
		Optional<Person> person = repo.findById(id);
		
		if(person.isEmpty()) {
			return Optional.empty();
		}
		
		return Optional.of(mapToDTO(person.orElseThrow()));
	}

	@Override
	public List<PersonDTO> readAll() {
		List<PersonDTO> list = repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
		return list;
	}

	@Override
	public Optional<PersonDTO> update(Integer id, Person model) {
		Optional<PersonDTO> oldEntry = read(id);
		Person result;
		
		if(!oldEntry.isEmpty()) {
			result = mapToModel(oldEntry.orElseThrow());
			ModelUtility.mergeNotNull(model, result);
			oldEntry = Optional.of(mapToDTO(repo.save(result)));
			
			return oldEntry;
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<PersonDTO> delete(Integer id) {
		Optional<PersonDTO> person = read(id);
		
		if(!person.isEmpty()) {
			repo.deleteById(id);
			return person;
		} else {
			return Optional.empty();
		}
	}
}
