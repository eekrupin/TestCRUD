package com.eekrupin.testCRUD.dao;

import com.eekrupin.testCRUD.Direction;
import com.eekrupin.testCRUD.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    void updateUser(User user);
    void removeUser(int id);
    User getUser(int id);
    List<User> listUsers(String searchName);
    List<User> listUsers(int id, Direction direction, String searchName);
}
