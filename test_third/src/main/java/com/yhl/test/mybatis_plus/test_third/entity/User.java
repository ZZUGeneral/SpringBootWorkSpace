package com.yhl.test.mybatis_plus.test_third.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 杨贺龙
 * @name entity
 * @create 2019-11-14 16:34
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
// @TableName("tb_user")
public class User extends Model<User> {
   // @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    @TableField(select = false)  //查询时不加入查询字段
    private String password;
    private String name;
    private Integer age;
    @TableField(value = "email")//指定数据表中字段名
    private String mail;

    @TableField(exist = false)//在数据表中不存在
    private String address;
}
