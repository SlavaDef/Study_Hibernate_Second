package org.hibernate_test.data;

import java.util.List;

import org.hibernate_test.data.dto.AddressDto;
import org.hibernate_test.data.dto.AddressDtoImpl;
import org.hibernate_test.data.entities.Accaunts;
import org.hibernate_test.data.entities.Address;
import org.hibernate_test.data.entities.User;
import org.hibernate_test.data.dto.UserDto;
import org.hibernate_test.data.dto.UserDtoImpl;

public class Application {

    public static void main(String[] args) {
        UserDto dto = new UserDtoImpl();

        dto.createSomeUsers(10);

        AddressDto ad = new AddressDtoImpl();

       User user = dto.getById(5L);

        user.setFirst_name("new Name");
        user.setLast_name("New Last_name");

        Address address1 = new Address("099-324-23-23","St.Brown street","Brown@gmail.com");
        Address address2 = new Address("033-234-66-19","St.Jofri street","Jof44@gmail.com");
        Address address3 = new Address("055-557-69-40","St.Arni street","Arni25@gmail.com");
        ad.addAddress(address1);
        ad.addAddress(address2);
        user.setAccaunts(new Accaunts("ip33422-33", "ip33422-88"));
        address2.setUser(user);
        address1.setUser(user);
        user.getAddressList().add(address1);
        user.getAddressList().add(address2);
         dto.updateUser(user);
       //  System.out.println(dto.getByIdUserAddress(5L));

        User user1 = new User("Arni", "Svainstaiger");
        address3.setUser(user1);
        user1.getAddressList().add(address3);
        dto.updateUser(user1);


       //  dto.printUsers(dto.getAllUsers());

     // System.out.println(ad.getAllAddresses());

      User user2 = dto.getById(2L);
      address2.setUser(user2);
      user2.getAddressList().add(address2);
      dto.updateUser(user2);
    //  ad.deleteAddress(ad.getById(1L));
        dto.deleteUser(dto.getById(5L));


      Address address = dto.getByIdUserAddress(1L);

      address.setEmail("new email");
      address.setUser(dto.getById(1L));

      ad.updateAddress(address);
        dto.printUsers(dto.getAllUsers());


    }
}
