package com.biofish.lifesummary.controller;

import com.biofish.lifesummary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ClassName UserController
 * @Description 用户管理
 * @Auther bioFish
 * @Date 2020/1/17 14:48
 * @Version v1.0
 **/
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    
    public String saveUserInfo(){

        userService.insertUser();
        return null;
    }
}
