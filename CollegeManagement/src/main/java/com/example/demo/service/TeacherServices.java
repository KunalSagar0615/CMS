package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TeacherDTORequest;
import com.example.demo.dto.TeacherDTOResponse;
import com.example.demo.model.Teacher;

public interface TeacherServices {

	void add(TeacherDTORequest t);
	List<TeacherDTOResponse> display();
	TeacherDTOResponse search(Integer id);
	TeacherDTOResponse update(TeacherDTORequest t,Integer id);
	TeacherDTOResponse delete(Integer id);
}
