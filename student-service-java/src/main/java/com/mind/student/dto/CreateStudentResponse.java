package com.mind.student.dto;

import com.mind.student.entity.Student;

public class CreateStudentResponse {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String street;
	private String city;
	
	public CreateStudentResponse() {
		super();
	}
	
	
	public CreateStudentResponse(Long id, String firstName, String lastName, String email, String street, String city) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.street = street;
		this.city = city;
	}


	public CreateStudentResponse(Student student, Address address){
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		this.street = address.getStreet();
		this.city = address.getCity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

}
