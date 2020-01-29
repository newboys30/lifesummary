package com.biofish.lifesummary.service.impl;

import com.biofish.lifesummary.dao.DAO;
import com.biofish.lifesummary.pojo.t_user;
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
    public boolean insertUser(t_user user) {
        try {
            return dao.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(t_user user) {
        return dao.update(user);
    }

    @Override
    public boolean deleteById(int id) {
        return dao.deleteById(id);
    }

    @Override
    public Class getUserById(int id) {
        return dao.getOneById(id, t_user.class);
    }

    @Override
    public List<t_user> getUserList(t_user user) {
        return null;
    }
}