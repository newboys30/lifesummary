package com.biofish.lifesummary.service;

import org.omg.CORBA.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.lang.Object;

/**
 * 用户实现类
 */
@Service
public class UserServiceImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(){
        String sql = "insert into t_user (username, password, nickname, email) values ( ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{"bioFish","123456","鱼鱼鱼","newbos@gmail.com"});
    }

}
