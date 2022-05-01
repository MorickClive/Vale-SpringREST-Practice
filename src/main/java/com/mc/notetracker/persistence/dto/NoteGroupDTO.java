package com.mc.notetracker.persistence.dto;

import java.util.List;

import com.mc.notetracker.persistence.domain.Note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteGroupDTO {
	private Integer id;
	private String label;
	private List<NoteDTO> noteList;
}
