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
public class HOD {
	
	@Id
	private Integer id;
	private String name;
	private String mob;
	private Float exp;
	private String username;
	private String pass;
	private String email;
	private String dept;
	private String roll;
}
