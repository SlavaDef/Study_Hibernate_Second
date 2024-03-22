package org.hibernate_test.data.dto;

import org.hibernate_test.data.entities.Address;

public interface AddressDto {

    Address addAddress(Address address);

    Address getById(Long id);
}
