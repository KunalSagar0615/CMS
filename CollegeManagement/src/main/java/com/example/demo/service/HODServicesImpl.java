package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void add(HOD hod) {
		
		String dept=hod.getDept();
		
		vu.validId(hod.getId());
		
		vu.validEmail(hod.getEmail());
		
		vu.validMob(hod.getMob());
		
		if(!(dept.equalsIgnoreCase("BCA") || dept.equalsIgnoreCase("BCS") || dept.equalsIgnoreCase("IT") || dept.equalsIgnoreCase("CS") || dept.equalsIgnoreCase("ENTC")))
			throw new InvalidDept("Invalid Department");
			
		hr.save(hod);
	}

	@Override
	public List<HOD> display() {
		return hr.findAll();
	}

	@Override
	public HOD search(Integer id) {	
		vu.validId(id);
		return hr.findById(id).orElse(null);
	}

	@Override
	public HOD update(HOD hod, Integer id) {
		
		return null;
	}

	@Override
	public HOD delete(Integer id) {
		
		vu.validId(id);
		
		if(hr.findById(id).isPresent()) {
			HOD temp=hr.findById(id).get();
			hr.deleteById(id);
			return temp;
		}
		return null;
	}

	

}
