package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TeacherDTORequest;
import com.example.demo.dto.TeacherDTOResponse;
import com.example.demo.exception.validUser;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;

@Service
public class TeacherServicesImp implements TeacherServices {
	
	@Autowired
	private TeacherRepository tr;

	@Autowired
	private validUser vu;
	
	
	@Override
	public void add(TeacherDTORequest t) {
		
		vu.validEmail(t.getEmail());
		vu.validId(t.getId());
		vu.validMob(t.getMob());
		
		Teacher teacher=TeacherDTORequest.toEntityTeacher(t);
		
		tr.save(teacher);
	}

	@Override
	public List<TeacherDTOResponse> display() {
		return tr.findAll().stream().map(TeacherDTOResponse::toTeacherDTOResponse).toList();
	}

	@Override
	public TeacherDTOResponse search(Integer id) {
		
		vu.validId(id);
		Teacher teacher=tr.findById(id).orElseThrow(()->new RuntimeException("Teacher not found !"));
		return TeacherDTOResponse.toTeacherDTOResponse(teacher);
	}

	@Override
	public TeacherDTOResponse update(TeacherDTORequest dto, Integer id) {
		Teacher teacher=tr.findById(id).orElseThrow(()->new RuntimeException("Teacher Not found !!"));
		
		teacher.setName(dto.getName());
		teacher.setEmail(dto.getEmail());
		teacher.setMob(dto.getMob());

		tr.save(teacher);		
		return TeacherDTOResponse.toTeacherDTOResponse(teacher);
	}

	@Override
	public TeacherDTOResponse delete(Integer id) {
		
		vu.validId(id);
		
		Teacher teacher=tr.findById(id).orElseThrow(()->new RuntimeException("Teacher not found"));
		tr.delete(teacher);
	
		return TeacherDTOResponse.toTeacherDTOResponse(teacher);
	}

}
