package com.mind.address.service;

import org.springframework.http.ResponseEntity;

import com.mind.address.entity.Address;
import com.mind.address.exceptions.AddressNotFoundException;

public interface AddressService {
	Address save(Address request);
	Address findById(Long id) throws AddressNotFoundException;
	ResponseEntity<String> deleteById(Long addressId);

}
