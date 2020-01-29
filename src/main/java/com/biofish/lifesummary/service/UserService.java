package com.biofish.lifesummary.service;

import com.biofish.lifesummary.pojo.t_user;

import java.util.List;


/**
 * User接口
 */
public interface UserService {
    boolean insertUser(t_user user);
    boolean updateUser(t_user user);
    boolean deleteById(int id);
    Class getUserById(int id);
    List<t_user> getUserList(t_user user);
}
