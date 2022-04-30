package com.mc.notetracker.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mc.notetracker.persistence.domain.Note;
import com.mc.notetracker.persistence.dto.NoteDTO;
import com.mc.notetracker.services.NoteService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping(path = "/notetracker/note")
@NoArgsConstructor
public class NoteController {
	
	private NoteService service;
	
	@Autowired
	public NoteController(NoteService service) {
		super();
		this.service = service;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<NoteDTO>  create(@RequestBody Note Note) {
		return ResponseEntity.ok(service.create(Note));
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ResponseEntity<NoteDTO> read(@PathParam(value = "id") Integer id) {
		return ResponseEntity.of(service.read(id));
	}

	@RequestMapping(value = "/readall", method = RequestMethod.GET)
	public ResponseEntity<List<NoteDTO>> readAll() {
		return ResponseEntity.ok(service.readAll());		
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<NoteDTO> update(@PathParam(value = "id") Integer id, @RequestBody Note Note) {
		return ResponseEntity.of(service.update(id, Note));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<NoteDTO> delete(@PathParam(value = "id") Integer id) {
		return ResponseEntity.of(service.delete(id));
	}

}
