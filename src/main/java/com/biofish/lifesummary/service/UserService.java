package com.biofish.lifesummary.service;

import com.biofish.lifesummary.entity.User;

import java.util.List;

/**
 * User接口
 */
public interface UserService {
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteById(int id);
    Class getUserById(int id);
    List<User> getUserList(User user);
}
