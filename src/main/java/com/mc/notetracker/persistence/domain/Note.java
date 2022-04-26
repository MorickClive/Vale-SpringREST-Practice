package com.mc.notetracker.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Note {
	
	private Integer id;
	private Integer fkId;
	private String header;
	private String contents;

}
