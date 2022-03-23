package org.itee.se.demo.Service;

import org.itee.se.demo.pojo.User;

public interface UserServiceI {
    boolean login(String userName, String password);

    boolean logout();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);
}
