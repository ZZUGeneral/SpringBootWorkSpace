package com.yhl.test.mybatis_plus.test_third;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @MapperScan("com.yhl.test.mybatis_plus.test_third.mapper") //设置mapper接口的扫描包
@SpringBootApplication
public class TestThirdApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestThirdApplication.class, args);
    }

}
