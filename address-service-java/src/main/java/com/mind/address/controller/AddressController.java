package com.mind.address.controller;


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

import com.mind.address.entity.Address;
import com.mind.address.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/create")
	public Address save(@RequestBody Address request) {
		return addressService.save(request);
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<Address> findById(@PathVariable Long id) {
		Address address = addressService.findById(id);
		return ResponseEntity.ok(address);
	}
	@PutMapping("/update")
	public Address update(@RequestBody Address request){
		return addressService.save(request);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long addressId){
		return addressService.deleteById(addressId);
	}

}
