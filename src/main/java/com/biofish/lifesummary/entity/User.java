package com.biofish.lifesummary.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户实体类
 */
public class User {
    /**
     * id
     */
    @Getter
    @Setter
    private int id;
    /**
     * 用户名/登录名
     */
    @Getter
    @Setter
    private String username;
    /**
     * 密码
     */
    @Getter
    @Setter
    private String password;
    /**
     * 昵称
     */
    @Getter
    @Setter
    private String nickname;
    /**
     * E-mail
     */
    @Getter
    @Setter
    private String email;
    /**
     * 用户状态 1有效，2未生效，0已锁定
     */
    @Getter
    @Setter
    private int status;
}
