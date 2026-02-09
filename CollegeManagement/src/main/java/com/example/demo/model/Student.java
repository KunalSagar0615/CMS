package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

	@Id
	private Integer rollNo;
	private String name;
	private String div;
	private Integer year;
	private String username;
	private String pass;
	private String email;
	private String mob;
	private Float marks;
	private String role;
	
}
