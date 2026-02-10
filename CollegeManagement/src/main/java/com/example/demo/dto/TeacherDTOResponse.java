package com.example.demo.dto;

import com.example.demo.model.Teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TeacherDTOResponse {
	private Integer id;
	private String name;
	private String email;
	private String mob;
	
	public static TeacherDTOResponse toTeacherDTOResponse(Teacher t) {
		TeacherDTOResponse temp=new TeacherDTOResponse();
		
		temp.setId(t.getId());
		temp.setName(t.getName());
		temp.setEmail(t.getEmail());
		temp.setMob(t.getMob());
		
		return temp;		
	}
}
