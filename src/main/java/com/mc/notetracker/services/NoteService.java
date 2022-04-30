package com.mc.notetracker.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.notetracker.persistence.domain.Note;
import com.mc.notetracker.persistence.dto.NoteDTO;
import com.mc.notetracker.persistence.repos.NoteRepo;
import com.mc.notetracker.rest.CRUDOptions;
import com.mc.notetracker.util.ModelUtility;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class NoteService implements CRUDOptions<Note, NoteDTO> {
	
	private ModelMapper parser;
	private NoteRepo repo;
	
	private NoteDTO mapToDTO(Note obj) {
		return this.parser.map(obj, NoteDTO.class);
	}
	private Note mapToModel(NoteDTO obj) {
		return this.parser.map(obj, Note.class);
	}
	
	@Autowired
	public NoteService(NoteRepo repo, ModelMapper mapper, ModelUtility util) {
		super();
		this.repo = repo;
		this.parser = mapper;
	}

	@Override
	public NoteDTO create(Note model) {
		return mapToDTO(repo.save(model));
	}

	@Override
	public Optional<NoteDTO> read(Integer id) {
		Optional<Note> note = repo.findById(id);
		
		if(note.isEmpty()) {
			return Optional.empty();
		}
		
		return Optional.of(mapToDTO(note.orElseThrow()));
	}

	@Override
	public List<NoteDTO> readAll() {
		List<NoteDTO> list = repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
		return list;
	}

	@Override
	public Optional<NoteDTO> update(Integer id, Note model) {
		Optional<NoteDTO> oldEntry = read(id);
		Note result;
		
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
	public Optional<NoteDTO> delete(Integer id) {
		Optional<NoteDTO> person = read(id);
		
		if(!person.isEmpty()) {
			repo.deleteById(id);
			return person;
		} else {
			return Optional.empty();
		}
	}
}
