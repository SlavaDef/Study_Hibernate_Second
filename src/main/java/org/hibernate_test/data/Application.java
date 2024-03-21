package org.hibernate_test.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate_test.data.entities.User;
import org.hibernate_test.dto.UserDto;
import org.hibernate_test.dto.UserDtoImpl;

public class Application {

    public static void main(String[] args) {
        UserDto dto = new UserDtoImpl();
      //  User user = new User("Bob", "Dj", new Date(1L));
      //  User user2 = new User("Bob2", "Dj2", new Date());
     //  dto.addUser(user);
     //  dto.addUser(user2);
        dto.createSomeUsers(10);
        System.out.println(dto.getById(3L));

     //  dto.printUsers(dto.getAllUsers());
    }
}
