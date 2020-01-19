package com.biofish.lifesummary.entity;

import lombok.Data;

/**
 * 用户实体类
 */
@Data
public class User {
    /**
     * id
     */
    private int id;
    /**
     * 用户名/登录名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * E-mail
     */
    private String email;
    /**
     * 用户状态 1有效，2未生效，0已锁定
     */
    private int status;
}
