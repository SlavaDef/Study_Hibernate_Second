package org.hibernate_test.data.dto;

import org.hibernate_test.data.entities.Address;

import java.util.List;

public interface AddressDto {

    Address addAddress(Address address);

    Address getById(Long id);

    List<Address> getAllAddresses();

    boolean deleteAddress(Address address);

    Address updateAddress(Address address);
}
