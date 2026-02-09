package com.example.demo.exception;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.HODRespository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;

public class validUser {

	@Autowired
	private StudentRepository sr;
	
	@Autowired
	private TeacherRepository tr;
	
	@Autowired 
	private HODRespository hr;
	
	
	
	public void validId(Integer id) {		
		if(id<=0)
			throw new IdMustBeUnique("Id must be greater than 0 !!");
		
		if(sr.findById(id).isPresent() || tr.findById(id).isPresent() || hr.findById(id).isPresent()) 
			throw new IdMustBeUnique("Duplicate Id Is Not Allowed !!");		
	}
	
	
	
	
	public void validEmail(String email) {		
		String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		if(email.matches(pattern))
			throw new EmailMustBeUnique("Invalid Email Formate");
		
		if(sr.findByEmail(email) || tr.findByEmail(email) || hr.findByEmail(email))
			throw new EmailMustBeUnique("Duplicate Email Not Allowed !!");
	}
	
	public void validMob(String mob) {
		if(mob.length() <10 || mob.length()>10)
			throw new InvalidMob("Mobile number must be 10 digits!!");
		
		if(sr.findByMob(mob) || tr.findByMob(mob) || hr.findByMob(mob))
			throw new InvalidMob("Duplicate mobile not allowed !!");
	}
	
	
}
