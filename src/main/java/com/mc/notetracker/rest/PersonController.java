package com.mc.notetracker.rest;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mc.notetracker.persistence.domain.Person;
import com.mc.notetracker.persistence.dto.PersonDTO;
import com.mc.notetracker.services.PersonService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping(path = "/notetracker/person")
@NoArgsConstructor
public class PersonController {
	
	private PersonService service;
	
	@Autowired
	public PersonController(PersonService service) {
		super();
		this.service = service;
	}
	
	@RequestMapping(value = "/greet", method = RequestMethod.GET)
	public String greet() {
		return "Hello";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<PersonDTO>  create(@RequestBody Person person) {
		return ResponseEntity.ok(service.create(person));
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ResponseEntity<PersonDTO> read(@PathParam(value = "id") Integer id) {
		return ResponseEntity.of(service.read(id));
	}

	@RequestMapping(value = "/readall", method = RequestMethod.GET)
	public ResponseEntity<List<PersonDTO>> readAll() {
		return ResponseEntity.ok(service.readAll());		
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<PersonDTO> update(@PathParam(value = "id") Integer id, @RequestBody Person person) {
		return ResponseEntity.of(service.update(id, person));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<PersonDTO> delete(@PathParam(value = "id") Integer id) {
		return ResponseEntity.of(service.delete(id));
	}

}
