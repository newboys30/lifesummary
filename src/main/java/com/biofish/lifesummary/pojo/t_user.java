package com.biofish.lifesummary.pojo;

import com.biofish.lifesummary.annotation.Increment;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * 用户pojo,类名必须与数据库表名一致
 */
@Data
public class t_user {
    /**
     * id
     */
    @Increment(isInrement = true)
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
