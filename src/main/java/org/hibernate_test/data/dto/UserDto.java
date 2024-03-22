package org.hibernate_test.data.dto;

import org.hibernate_test.data.entities.Address;
import org.hibernate_test.data.entities.User;

import java.util.List;

public interface UserDto {
    User addUser(User user);

    List<User> getAllUsers();

    void printUsers(List<User> users);

    void createSomeUsers(int count);

    User getById(Long id);

    boolean deleteUser(User user);

    User updateUser(User user);

    Address getByIdUserAddress(Long id);
}
