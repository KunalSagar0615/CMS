package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void add(Teacher t) {
		
		vu.validEmail(t.getEmail());
		vu.validId(t.getId());
		vu.validMob(t.getMob());
		
		
		tr.save(t);
	}

	@Override
	public List<Teacher> display() {
		return tr.findAll();
	}

	@Override
	public Teacher search(Integer id) {
		
		vu.validId(id);

		if(tr.findById(id).isPresent()) {
			return tr.findById(id).get();
		}
		return null;
	}

	@Override
	public Teacher update(Teacher t, Integer id) {
		t.setId(id);
		tr.save(t);
		return tr.findById(id).get();
	}

	@Override
	public Teacher delete(Integer id) {
		
		vu.validId(id);
		
		if(tr.findById(id).isPresent()) {
			Teacher temp=tr.findById(id).get();
			tr.deleteById(id);
			return temp;
		}
		return null;
	}

}
