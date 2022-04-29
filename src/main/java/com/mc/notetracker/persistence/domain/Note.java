package com.mc.notetracker.persistence.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Note {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer fkId;
	private String header;
	private String contents;

}
