package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TeacherDTORequest;
import com.example.demo.dto.TeacherDTOResponse;
import com.example.demo.service.TeacherServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
public class TeacherController {

	@Autowired
	private TeacherServices teacherServices;

	@PostMapping("/teacher/add")		
	public void add(@RequestBody TeacherDTORequest entity) {		
		teacherServices.add(entity);
	}
	
	
	@GetMapping("/teacher/display")
	public List<TeacherDTOResponse> display() {
		return teacherServices.display();
	}
	
	@GetMapping("/teacher/search/{id}")
	public TeacherDTOResponse search(@PathVariable Integer id) {
		return teacherServices.search(id);
	}
	
	@PutMapping("/teacher/update/{id}")
	public TeacherDTOResponse update(@PathVariable Integer id, @RequestBody TeacherDTORequest dto) {		
		return teacherServices.update(dto,id);
	}
	
	@DeleteMapping("/teacher/delete/{id}")
	public TeacherDTOResponse delete(@PathVariable Integer id) {
		return teacherServices.delete(id);
	}
	
	
}
