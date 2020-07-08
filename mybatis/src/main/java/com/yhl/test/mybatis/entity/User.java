package com.yhl.test.mybatis.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 杨贺龙
 * @name User
 * @create 2019-11-12 17:28
 * @description:
 */
@Data
public class User {
    private Long id;
    private String name;
    private String code;
    private String status;
    private Date gmt_greate;
    private Date gmt_modified;
}
