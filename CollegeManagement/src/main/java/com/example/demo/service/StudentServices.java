package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentServices {

	void add(Student s);
	List<Student> display();
	Student update(Student s, Integer id);
	Student search(Integer id);
	Student delete(Integer id);
}
