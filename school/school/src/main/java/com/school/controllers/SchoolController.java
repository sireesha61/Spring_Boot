package com.school.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.school.bean.School;
import com.school.service.SchoolService;

@RestController
@RequestMapping("/school")

public class SchoolController {
	@Autowired
	SchoolService service;
	
	@PostMapping("/add")
	public ResponseEntity<School> addSchoolName(@RequestBody School model) {
		School bean = service.addSchoolName(model);
		return ResponseEntity.ok(bean);
	}
		
	@GetMapping("/all")
	public ResponseEntity<List<School>> getSchoolName() {
		List<School> bean = service.getSchoolName();
		return ResponseEntity.ok(bean);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<School> getOneSchoolName(@PathVariable String id) {
		School bean = service.getOneSchoolName(id);
		return ResponseEntity.ok(bean);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<School> update(@RequestBody School model, @PathVariable String id ) {
		School bean = service.update(model,id);
		return ResponseEntity.ok(bean);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable String id) {
		service.deleteById(id);
	}
}
		
//		if(bean!=null) {
//			return ResponseEntity.ok(bean); 
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//			.body(bean);
//			}
	