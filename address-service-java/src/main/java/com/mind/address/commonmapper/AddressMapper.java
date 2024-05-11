package com.mind.address.commonmapper;

import com.mind.address.dto.AddressDto;
import com.mind.address.entity.Address;

public class AddressMapper {
	public static AddressDto mapToAddressDto(Address address) {
		return new AddressDto();
	}

}
