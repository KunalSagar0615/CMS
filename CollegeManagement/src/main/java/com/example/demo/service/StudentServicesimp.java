package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.validUser;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServicesimp implements StudentServices {

	
	@Autowired
	private StudentRepository sr;
	
	@Autowired
	private validUser vu;
	
	@Override
	public void add(Student s) {
		vu.validId(s.getRollNo());
		vu.validEmail(s.getEmail());
		vu.validMob(s.getMob());
		sr.save(s);
	}

	@Override
	public List<Student> display() {		
		return sr.findAll();
	}

	@Override
	public Student update(Student s, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student search(Integer id) {
		
		vu.validId(id);
		
		if(sr.findById(id).isPresent()) {
			return sr.findById(id).get();
		}
		return null;
	}

	@Override
	public Student delete(Integer id) {
		
		vu.validId(id);
		
		if(sr.findById(id).isPresent()) {
			Student temp=sr.findById(id).get();
			sr.deleteById(id);
			return temp;
		}
		return null;
	}

}
