package com.biofish.lifesummary.service.impl;

import com.biofish.lifesummary.dao.DAO;
import com.biofish.lifesummary.entity.User;
import com.biofish.lifesummary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DAO dao;

    @Override
    public boolean insertUser(User user) {
        return dao.insert(user);
    }

    @Override
    public boolean updateUser(User user) {
        return dao.update(user);
    }

    @Override
    public boolean deleteById(int id) {
        return dao.deleteById(id);
    }

    @Override
    public Class getUserById(int id) {
        return dao.getOneById(id, User.class);
    }

    @Override
    public List<User> getUserList(User user) {
        return null;
    }
}