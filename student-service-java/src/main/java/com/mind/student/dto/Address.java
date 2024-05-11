package com.mind.student.dto;

public class Address {
	private Long id;
	private String street;
	private String city;
	public Address() {
		super();
	}
	public Address(Long id,String street, String city) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}
