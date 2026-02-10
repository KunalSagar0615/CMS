package com.example.demo.dto;

import com.example.demo.model.HOD;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HODDTORequest {
	
	private Integer id;
	private String name;
	private String mob;
	private Float exp;
	private String email;
	private String dept;
	private String role;
	private String pass;
	private String username;
	
	public static HOD toEntiyHod(HODDTORequest h) {

		HOD temp=new HOD();
		
		temp.setId(h.getId());
		temp.setName(h.getName());
		temp.setMob(h.getMob());
		temp.setDept(h.getDept());
		temp.setEmail(h.getEmail());
		temp.setExp(h.getExp());
		temp.setRole("HOD");
		temp.setUsername(h.getName()+h.getId());
		temp.setPass(h.getPass());
		
		
		return temp;
	}
}
