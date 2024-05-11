package com.mind.student.service;

import java.util.List;

import com.mind.student.dto.CreateStudentRequest;
import com.mind.student.dto.CreateStudentResponse;



public interface StudentService {
	CreateStudentResponse save(CreateStudentRequest request);
	
	List<CreateStudentResponse> findAll();

	CreateStudentResponse findById(Long id);

	CreateStudentResponse update(CreateStudentResponse request);

	void deleteById(Long id);
	
	String getGreetMessage();

}
