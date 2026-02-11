package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.HODDTORequest;
import com.example.demo.dto.HodDTOResponse;
import com.example.demo.model.HOD;

public interface HODServices {

	void addHOD(HODDTORequest hod);
	List<HodDTOResponse> display();
	HodDTOResponse search(Integer id);
	HodDTOResponse update(HODDTORequest hod,Integer id);
	HodDTOResponse delete(Integer id);
	
}
