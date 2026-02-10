package com.example.demo.dto;

import com.example.demo.model.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTORequest {

	private Integer rollNo;
	private String name;
	private String div;
	private Integer year;
	private String email;
	private String mob;
	private Float marks;
	private String role;
	private String pass;
	private String username;
	
	public static Student toEntityStudent(StudentDTORequest s) {
		
		Student temp=new Student();
		
		temp.setRollNo(s.getRollNo());
		temp.setName(s.getName());
		temp.setDiv(s.getDiv());
		temp.setEmail(s.getEmail());
		temp.setYear(s.getYear());
		temp.setMob(s.getMob());
		temp.setPass(s.getPass());
		temp.setUsername(s.getName()+s.getRollNo());
		temp.setRole("Student");		
		
		return temp;
	}
}
