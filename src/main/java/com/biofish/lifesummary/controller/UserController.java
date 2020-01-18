package com.biofish.lifesummary.controller;

import com.biofish.lifesummary.controller.base.BaseController;
import com.biofish.lifesummary.entity.ResultModule;
import com.biofish.lifesummary.entity.User;
import com.biofish.lifesummary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName UserController
 * @Description 用户管理
 * @Auther bioFish
 * @Date 2020/1/17 14:48
 * @Version v1.0
 **/
@Controller
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/saveuser")
    public String saveUserInfo(User user){
        boolean status = userService.insertUser(user);
        return String.valueOf(status);
    }


}
