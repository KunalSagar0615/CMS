package com.example.demo.service;

import java.util.List;

import com.example.demo.model.HOD;

public interface HODServices {

	void add(HOD hod);
	List<HOD> display();
	HOD search(Integer id);
	HOD update(HOD hod,Integer id);
	HOD delete(Integer id);
	
}
