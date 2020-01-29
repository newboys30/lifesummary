package com.biofish.lifesummary.controller;

import com.biofish.lifesummary.controller.base.BaseController;
import com.biofish.lifesummary.pojo.t_user;
import com.biofish.lifesummary.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description 用户管理
 * @Auther bioFish
 * @Date 2020/1/17 14:48
 * @Version v1.0
 **/
@RestController
@RequestMapping(value="/admin/user")
public class UserController extends BaseController {
    @Resource
    private UserService userService;

    @PostMapping(value="/saveuser")
    public String saveUserInfo(@RequestBody t_user user){
        boolean status = userService.insertUser(user);
        return String.valueOf(status);
    }


}
