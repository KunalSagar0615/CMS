package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentDTORequest;
import com.example.demo.dto.StudentDTOResponse;
import com.example.demo.model.Student;

public interface StudentServices {

	void add(StudentDTORequest s);
	List<StudentDTOResponse> display();
	StudentDTOResponse update(StudentDTORequest s, Integer id);
	StudentDTOResponse search(Integer id);
	StudentDTOResponse delete(Integer id);
}
