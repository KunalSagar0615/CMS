package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.HODDTORequest;
import com.example.demo.dto.HodDTOResponse;
import com.example.demo.exception.InvalidDept;
import com.example.demo.exception.validUser;
import com.example.demo.model.HOD;
import com.example.demo.repository.HODRespository;

@Service
public class HODServicesImpl implements HODServices {
	
	@Autowired
	private HODRespository hr;

	@Autowired
	private validUser vu;
	
	@Override
	public void addHOD(HODDTORequest h) {
		
		String dept=h.getDept();
		
		vu.validId(h.getId());
		
		vu.validEmail(h.getEmail());
		
		vu.validMob(h.getMob());
		
		if (dept == null) {
		    throw new InvalidDept("Department cannot be null");
		}
		
		if(!(dept.equalsIgnoreCase("BCA") || dept.equalsIgnoreCase("BCS") || dept.equalsIgnoreCase("IT") || dept.equalsIgnoreCase("CS") || dept.equalsIgnoreCase("ENTC")))
			throw new InvalidDept("Invalid Department");
			
		HOD hod=HODDTORequest.toEntiyHod(h);
		hr.save(hod);
	}

	@Override
	public List<HodDTOResponse> display() {
		return hr.findAll().stream().map(HodDTOResponse::toResponseHod).toList();
	}

	@Override
	public HodDTOResponse search(Integer id) {	
		vu.validId(id);
		HOD hod=hr.findById(id).orElseThrow(()->new RuntimeException("HOD not found !"));		
		return HodDTOResponse.toResponseHod(hod);
	}

	@Override
	public HodDTOResponse update(HODDTORequest dto, Integer id) {
		vu.validId(id);
		HOD hod=hr.findById(id).orElseThrow(()->new RuntimeException("HOD not found !"));
		
		hod.setName(dto.getName());
		hod.setEmail(dto.getEmail());
		hod.setExp(dto.getExp());
		hod.setMob(dto.getMob());
		hod.setDept(dto.getDept());
		
		hr.save(hod);
	
		return HodDTOResponse.toResponseHod(hod);
	}

	@Override
	public HodDTOResponse delete(Integer id) {
		
		vu.validId(id);
		HOD hod=hr.findById(id).orElseThrow(()->new RuntimeException("HOD not found !"));
		hr.delete(hod);
		
		return HodDTOResponse.toResponseHod(hod);		
	}

	

}
