package com.yhl.test.swagger.pojo;

import lombok.Data;

/**
 * @author 杨贺龙
 * @name User
 * @create 2019-11-04 10:33
 * @description:
 */
@Data
public class User {
        private String username;
        private  String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
