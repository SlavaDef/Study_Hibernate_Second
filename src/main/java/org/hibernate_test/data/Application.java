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
      //  System.out.println(dto.deleteUser(dto.getById(3L)));
        AddressDto ad = new AddressDtoImpl();

       User user = dto.getById(5L);
     //   User user = new User();
        user.setFirst_name("gggggggggggggggg");
        user.setLast_name("22");

        Address address1 = new Address("8888","fddffdfd","dsdssd@com");
        Address address2 = new Address("8888","fddffdfd","dsdssd@com");
        ad.addAddress(address1);
        ad.addAddress(address2);
     //  List<Address> addressList = user.getAddressList();
    //  addressList.add(address1);
    //   addressList.add(address2);
     //   user.setAddressList(addressList);
     //   dto.updateUser(user);
       // System.out.println(user.getAddressList());
        //System.out.println(dto.getById(5L));
      // System.out.println( dto.getByIdUderAddress(5L));
       // user.setAddressList(List.of(ad.getById(1L),ad.getById(2L)));
        user.setAccaunts(new Accaunts("first", "second"));
      //  dto.addUser(user);

        address1.setUser(user);
        user.getAddressList().add(address1);
         dto.updateUser(user);
       //  System.out.println(dto.getByIdUserAddress(5L));


         dto.printUsers(dto.getAllUsers());


    }
}
