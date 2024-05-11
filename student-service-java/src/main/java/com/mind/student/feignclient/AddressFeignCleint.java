package com.mind.student.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mind.student.dto.Address;


@FeignClient(name = "address-service", url = "${address_service_url}")
public interface AddressFeignCleint {
	@PutMapping("/update")
	public Address update(@RequestBody Address request);
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long addressId);

}
