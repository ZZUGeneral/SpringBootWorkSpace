package com.yhl.test.springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨贺龙
 * @name LoginController
 * @create 2019-11-18 11:12
 * @description:
 */
@RestController
public class LoginController {
    @RequestMapping(value = "/login-success",produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess(){
        return " 登录成功";
    }

    /**
     * 测试资源1
     * @return
     */
    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
    public String r1(){
        return " 访问资源1";
    }
    /**
     * 测试资源2
     * @return
     */
    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
    public String r2(){
        return " 访问资源2";
    }
}
