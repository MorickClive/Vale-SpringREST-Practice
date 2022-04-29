package com.mc.notetracker.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
	private Integer id;
	private String forename;
	private String surname;
	private Integer age;
}
