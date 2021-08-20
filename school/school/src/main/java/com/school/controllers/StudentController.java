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

import com.school.bean.BeanClass;
import com.school.bean.Student;
import com.school.service.StudentService;
@RestController
@RequestMapping("/Student")
public class StudentController {
	@Autowired
	StudentService service;
	
	@PostMapping("/create")
	public ResponseEntity<Student> addStudent(@RequestBody Student bean) {
		Student model = service.addStudent(bean);
		return ResponseEntity.ok(model);
	}
	@GetMapping("/read")
	public ResponseEntity<List<Student>> getStudent() {
		List<Student> model = service.getStudent();
		return ResponseEntity.ok(model);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Student> getOneStudent(@PathVariable String id) {
		Student model = service.getOneStudent(id);
		return ResponseEntity.ok(model);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student bean,@PathVariable String id) {
		Student detail = service.update(bean,id);
		return ResponseEntity.ok(detail); 
	}
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable String id) {
		service.deleteStudent(id);
	}
	@PostMapping("/token")
	public ResponseEntity<BeanClass> getJwt(@RequestBody Student token) {
		return ResponseEntity.ok(service.getToken(token));
	}
}
