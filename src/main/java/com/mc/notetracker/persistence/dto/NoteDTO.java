package com.mc.notetracker.persistence.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer fkId;
	private String header;
	private String contents;

}
