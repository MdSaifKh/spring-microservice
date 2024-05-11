package com.mind.address.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mind.address.entity.Address;
import com.mind.address.exceptions.AddressNotFoundException;
import com.mind.address.repository.AddressRepository;
import com.mind.address.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address save(Address request) {
		return addressRepository.save(request);
	}

	@Override
	public Address findById(Long id) {
		return addressRepository.findById(id).orElseThrow(
					()-> new AddressNotFoundException("Address not found with this id")
				);
	}

	@Override
	public ResponseEntity<String> deleteById(Long addressId) {
		 addressRepository.findById(addressId).orElseThrow(
				()-> new AddressNotFoundException("Address not found with this id")
		 );
		 addressRepository.deleteById(addressId);
		 return ResponseEntity.ok("Account deleted successfully!");
		 
	}

}
