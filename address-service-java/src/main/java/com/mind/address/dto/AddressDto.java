package com.mind.address.dto;

public class AddressDto {
	private Long id;
	private String street;
	private String city;
	public AddressDto() {
		super();
	}
	public AddressDto(Long id,String street, String city) {
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
