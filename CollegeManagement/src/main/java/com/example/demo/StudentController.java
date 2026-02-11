package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDTORequest;
import com.example.demo.dto.StudentDTOResponse;
import com.example.demo.service.StudentServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentServices studentServices;

	@PostMapping
	public void add(@RequestBody StudentDTORequest entity) {		
		studentServices.add(entity);
	}
	
	@GetMapping
	public List<StudentDTOResponse> display() {
		return studentServices.display();
	}
	
	@GetMapping("/{id}")
	public StudentDTOResponse search(@PathVariable Integer id){
		return studentServices.search(id);
	}
	
	@PutMapping("/{id}")
	public StudentDTOResponse update(@RequestBody StudentDTORequest dto,@PathVariable Integer id) {
		return studentServices.update(dto, id);
	}
	
	@DeleteMapping("/{id}")
	public StudentDTOResponse delete(@PathVariable Integer id) {
		return studentServices.delete(id);
	}
	
	
}
