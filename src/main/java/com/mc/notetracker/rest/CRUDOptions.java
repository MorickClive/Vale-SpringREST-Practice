package com.mc.notetracker.rest;

import java.util.List;
import java.util.Optional;

import com.mc.notetracker.persistence.dto.PersonDTO;

public interface CRUDOptions<T, DTO> {
	
	DTO create(T model);
	Optional<DTO> read(Integer id);
	List<DTO> readAll();
	Optional<DTO> update(Integer id, T model);
	Optional<PersonDTO> delete(Integer id);

}
