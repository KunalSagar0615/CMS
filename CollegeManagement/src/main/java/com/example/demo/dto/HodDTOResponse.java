package com.example.demo.dto;

import com.example.demo.model.HOD;

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
	
	public static HodDTOResponse toResponseHod(HOD h) {
		
		HodDTOResponse temp=new HodDTOResponse();
		
		
		temp.setId(h.getId());
		temp.setName(h.getName());
		temp.setMob(h.getMob());
		temp.setExp(h.getExp());
		temp.setEmail(h.getEmail());
		temp.setDept(h.getDept());
		
		return temp;
	}
}
