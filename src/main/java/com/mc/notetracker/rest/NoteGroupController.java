package com.mc.notetracker.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mc.notetracker.persistence.domain.NoteGroup;
import com.mc.notetracker.persistence.dto.NoteGroupDTO;
import com.mc.notetracker.services.NoteGroupService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping(path = "/notetracker/notegroup")
@NoArgsConstructor
public class NoteGroupController {
	
	private NoteGroupService service;
	
	@Autowired
	public NoteGroupController(NoteGroupService service) {
		super();
		this.service = service;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<NoteGroupDTO>  create(@RequestBody NoteGroup model) {
		return ResponseEntity.ok(service.create(model));
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ResponseEntity<NoteGroupDTO> read(@PathParam(value = "id") Integer id) {
		return ResponseEntity.of(service.read(id));
	}

	@RequestMapping(value = "/readall", method = RequestMethod.GET)
	public ResponseEntity<List<NoteGroupDTO>> readAll() {
		return ResponseEntity.ok(service.readAll());		
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<NoteGroupDTO> update(@PathParam(value = "id") Integer id, @RequestBody NoteGroup model) {
		return ResponseEntity.of(service.update(id, model));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<NoteGroupDTO> delete(@PathParam(value = "id") Integer id) {
		return ResponseEntity.of(service.delete(id));
	}

}
