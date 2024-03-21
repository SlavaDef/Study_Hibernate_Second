package org.hibernate_test.dto;

import org.hibernate_test.data.entities.User;

import java.util.List;

public interface UserDto {
    User addUser(User user);

    List<User> getAllUsers();

    void printUsers(List<User> users);

    void createSomeUsers(int count);

    User getById(Long id);
}
