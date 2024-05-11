package com.mind.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mind.student.dto.CreateStudentRequest;
import com.mind.student.dto.CreateStudentResponse;
import com.mind.student.service.StudentService;



@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public ResponseEntity<CreateStudentResponse> save(@RequestBody CreateStudentRequest request){
		return new ResponseEntity<>(studentService.save(request),HttpStatus.CREATED);
	}
	
	@GetMapping("/read")
	public ResponseEntity<List<CreateStudentResponse>> findAll(){
		List<CreateStudentResponse> studentResponses = studentService.findAll();
		return ResponseEntity.ok(studentResponses);
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<CreateStudentResponse> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(studentService.findById(id));
	}
	@PutMapping("/update")
	public ResponseEntity<CreateStudentResponse> update(@RequestBody CreateStudentResponse request){
		return ResponseEntity.ok(studentService.update(request));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		studentService.deleteById(id);
		return ResponseEntity.ok("Student deleted successfully!");
	}
	
	@GetMapping("/greet")
	public ResponseEntity<String> getGreetMessage(){
		return ResponseEntity.ok(studentService.getGreetMessage());
	}

}
