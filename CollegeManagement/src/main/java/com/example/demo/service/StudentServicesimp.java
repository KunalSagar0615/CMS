package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTORequest;
import com.example.demo.dto.StudentDTOResponse;
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
	public void add(StudentDTORequest s) {
		vu.validId(s.getRollNo());
		vu.validEmail(s.getEmail());
		vu.validMob(s.getMob());
		Student student=StudentDTORequest.toEntityStudent(s);
		sr.save(student);
	}

	@Override
	public List<StudentDTOResponse> display() {		
		return sr.findAll().stream().map(StudentDTOResponse::toStudentDTOResponse).toList();
	}

	@Override
	public StudentDTOResponse update(StudentDTORequest dto, Integer id) {
		
		Student student=sr.findById(id).orElseThrow(()->new RuntimeException("Student Not Found !"));
		
		student.setName(dto.getName());
		student.setEmail(dto.getEmail());
		student.setMob(dto.getMob());
		student.setDiv(dto.getDiv());
		student.setYear(dto.getYear());
		student.setMarks(dto.getMarks());
		
		sr.save(student);
		
		return StudentDTOResponse.toStudentDTOResponse(student);
	}

	@Override
	public StudentDTOResponse search(Integer id) {
		
		vu.validId(id);
		Student student=sr.findById(id).orElseThrow(()->new RuntimeException("Student Not Found !"));
		
		return StudentDTOResponse.toStudentDTOResponse(student);
	}

	@Override
	public StudentDTOResponse delete(Integer id) {
		
		vu.validId(id);
		
		Student student=sr.findById(id).orElseThrow(()->new RuntimeException("Student Not Found !"));
		
		return StudentDTOResponse.toStudentDTOResponse(student);
		
	}

}
