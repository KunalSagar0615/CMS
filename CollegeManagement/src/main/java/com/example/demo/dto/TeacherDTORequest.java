package com.example.demo.dto;

import com.example.demo.model.Teacher;

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
	private String role;
	private String username;
	private String pass;
	
	public static Teacher toEntityTeacher(TeacherDTORequest t) {
		
		Teacher temp=new Teacher();
		
		
		temp.setId(t.getId());
		temp.setName(t.getName());
		temp.setEmail(t.getEmail());
		temp.setMob(t.getMob());
		temp.setRole("Teacher");
		temp.setUsername(t.getName()+t.getId());
		temp.setPass(t.getPass());
		
		return temp;
	}
}
