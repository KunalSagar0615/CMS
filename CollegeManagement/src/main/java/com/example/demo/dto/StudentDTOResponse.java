package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTOResponse {

	private Integer rollNo;
	private String name;
	private String div;
	private Integer year;
	private String email;
	private String mob;
	private Float marks;
}
