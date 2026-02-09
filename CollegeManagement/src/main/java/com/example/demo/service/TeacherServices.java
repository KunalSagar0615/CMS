package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Teacher;

public interface TeacherServices {

	void add(Teacher t);
	List<Teacher> display();
	Teacher search(Integer id);
	Teacher update(Teacher t,Integer id);
	Teacher delete(Integer id);
}
