package com.mc.notetracker.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.notetracker.persistence.domain.NoteGroup;
import com.mc.notetracker.persistence.dto.NoteGroupDTO;
import com.mc.notetracker.persistence.repos.NoteGroupRepo;
import com.mc.notetracker.persistence.repos.NoteRepo;
import com.mc.notetracker.rest.CRUDOptions;
import com.mc.notetracker.util.ModelUtility;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class NoteGroupService implements CRUDOptions<NoteGroup, NoteGroupDTO> {
	
	private ModelMapper parser;
	private NoteGroupRepo repo;
	
	private NoteGroupDTO mapToDTO(NoteGroup obj) {
		return this.parser.map(obj, NoteGroupDTO.class);
	}
	private NoteGroup mapToModel(NoteGroupDTO obj) {
		return this.parser.map(obj, NoteGroup.class);
	}
	
	@Autowired
	public NoteGroupService(NoteGroupRepo repo, ModelMapper mapper, ModelUtility util) {
		super();
		this.repo = repo;
		this.parser = mapper;
	}

	@Override
	public NoteGroupDTO create(NoteGroup model) {
		return mapToDTO(repo.save(model));
	}

	@Override
	public Optional<NoteGroupDTO> read(Integer id) {
		Optional<NoteGroup> note = repo.findById(id);
		
		if(note.isEmpty()) {
			return Optional.empty();
		}
		
		return Optional.of(mapToDTO(note.orElseThrow()));
	}

	@Override
	public List<NoteGroupDTO> readAll() {
		List<NoteGroupDTO> list = repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
		return list;
	}

	@Override
	public Optional<NoteGroupDTO> update(Integer id, NoteGroup model) {
		Optional<NoteGroupDTO> oldEntry = read(id);
		NoteGroup result;
		
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
	public Optional<NoteGroupDTO> delete(Integer id) {
		Optional<NoteGroupDTO> person = read(id);
		
		if(!person.isEmpty()) {
			repo.deleteById(id);
			return person;
		} else {
			return Optional.empty();
		}
	}
}
