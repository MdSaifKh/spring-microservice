package com.mind.student.service.impl;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.mind.student.dto.Address;
import com.mind.student.dto.CreateStudentRequest;
import com.mind.student.dto.CreateStudentResponse;
import com.mind.student.entity.Student;
import com.mind.student.exception.StudentNotFoundException;
import com.mind.student.feignclient.AddressFeignCleint;
import com.mind.student.feignclient.MessageFeignClient;
import com.mind.student.repositoty.StudentRepository;
import com.mind.student.service.StudentService;

import reactor.core.publisher.Mono;




@Service
public class StudentServiceImpl implements StudentService{
	
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private WebClient webClient;
	
	@Autowired
	private AddressFeignCleint addressFeignClient;
	
	@Autowired
	private MessageFeignClient messageFeignClient;
	
	

	@Override
	public CreateStudentResponse save(CreateStudentRequest request) {
		Address address = new Address();
		address.setStreet(request.getStreet());
		address.setCity(request.getCity());
		Long addressId = saveAddress(address).block().getId();
		
		
		Student student = new Student();
		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setEmail(request.getEmail());
		student.setAddressId(addressId);
		studentRepository.save(student);
		
		return new CreateStudentResponse(student, address);
		
		
	}
	public Mono<Address> saveAddress(Address address) {
		return webClient.post().uri("/create").
			contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(address)).
			retrieve().bodyToMono(Address.class);
	}
	

	@Override
	public List<CreateStudentResponse> findAll() {
		List<Object[]> objects = studentRepository.findAllStudentAndAddress();
		List<CreateStudentResponse> result = new ArrayList<CreateStudentResponse>();
		for(Object[] object:objects) {
			result.add(new CreateStudentResponse(
					(Long) object[0],
					(String) object[1],
					(String) object[2],
					(String) object[3],
					(String) object[4],
					(String) object[5]
					)
				);
		}
		return result;
		
	}
	@Override
	public CreateStudentResponse findById(Long id) {
		Student student = studentRepository.findById(id).orElseThrow(
					()-> new StudentNotFoundException("Student details not present with this id")
				);
		System.out.println("Address id ==> "+ student.getAddressId());
		Address address = getAddress(student.getAddressId());
		return new CreateStudentResponse(student,address);
	}
	private Address getAddress(Long address_id) {
		return this.webClient.get().uri("/findById/"+address_id).retrieve().bodyToMono(Address.class).block();
	}
	@Override
	public CreateStudentResponse update(CreateStudentResponse request) {
		Long addressId = studentRepository.findAddressIdByStudentId(request.getId().toString()).get(0);
		Address address = new Address(addressId, request.getStreet(), request.getCity());
		Address savedAddress = addressFeignClient.update(address);
		
		Student student = new Student();
		student.setId(request.getId());
		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setEmail(request.getEmail());
		student.setAddressId(savedAddress.getId());
		studentRepository.save(student);
		
		
		return new CreateStudentResponse(student, address);
	}
	@Override
	public void deleteById(Long id) {
		studentRepository.findById(id).orElseThrow(
				()-> new StudentNotFoundException("Student details not present with this id")
			);
		Long addressId = studentRepository.findAddressIdByStudentId(id.toString()).get(0);
		studentRepository.deleteById(id);
		addressFeignClient.deleteById(addressId);
	}
	@Override
	public String getGreetMessage() {
		return messageFeignClient.say_greet();
	}

}
