package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.HODDTORequest;
import com.example.demo.dto.HodDTOResponse;
import com.example.demo.service.HODServices;

@RestController
@RequestMapping("/hod")
public class HODController {

	private final HODServices hodServices;

	public HODController(HODServices hodServices) {
		this.hodServices = hodServices;
	}
	
	@PostMapping
	public void add(@RequestBody HODDTORequest entity){
		hodServices.addHOD(entity);
	}
	
	
	@GetMapping
	public List<HodDTOResponse> display(){
		return hodServices.display();
	}
	
	
	@GetMapping("/{id}")
	public HodDTOResponse search(@PathVariable Integer id) {
		return hodServices.search(id);
	}
	
	@PutMapping("/{id}")
	public HodDTOResponse update(@RequestBody HODDTORequest hod,@PathVariable Integer id) {
		return hodServices.update(hod, id);
	}
	
	@DeleteMapping("/{id}")
	public HodDTOResponse delete(@PathVariable Integer id) {
		return hodServices.delete(id);
	}
}
