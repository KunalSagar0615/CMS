package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTORequest {
	private Integer id;
	private String name;
	private String email;
	private String mob;
	private String roll;
}
