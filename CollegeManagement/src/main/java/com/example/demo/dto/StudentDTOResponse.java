package com.example.demo.dto;

import com.example.demo.model.Student;

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
	
	public static StudentDTOResponse toStudentDTOResponse(Student s) {
		StudentDTOResponse temp=new StudentDTOResponse();
		
		temp.setRollNo(s.getRollNo());
		temp.setName(s.getName());
		temp.setDiv(s.getDiv());
		temp.setYear(s.getYear());
		temp.setEmail(s.getEmail());
		temp.setMob(s.getMob());
		temp.setMarks(s.getMarks());
		
		return temp;
	}
}
