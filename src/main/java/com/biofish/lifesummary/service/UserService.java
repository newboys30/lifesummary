package com.biofish.lifesummary.service;

import com.biofish.lifesummary.pojo.T_User;

import java.util.List;


/**
 * User接口
 */
public interface UserService {
    boolean insertUser(T_User user);
    boolean updateUser(T_User user);
    boolean deleteById(int id);
    Class getUserById(int id);
    List<T_User> getUserList(T_User user);
}
