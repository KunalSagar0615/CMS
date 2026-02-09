package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HodDTOResponse {
	private Integer id;
	private String name;
	private String mob;
	private Float exp;
	private String email;
	private String dept;
	private String roll;
}
