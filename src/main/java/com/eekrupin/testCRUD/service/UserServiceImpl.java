package com.eekrupin.testCRUD.service;

import com.eekrupin.testCRUD.Direction;
import com.eekrupin.testCRUD.dao.UserDao;
import com.eekrupin.testCRUD.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return this.userDao.getUser(id);
    }

    @Override
    @Transactional
    public List<User> listUsers(String searchName) {
        return this.userDao.listUsers(searchName);
    }

    @Override
    @Transactional
    public List<User> listUsers(int id, Direction direction, String searchName) {
        return this.userDao.listUsers(id, direction, searchName);
    }
}
