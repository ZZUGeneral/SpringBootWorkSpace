package com.yhl.test.outputfirst.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.yhl.test.outputfirst.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 杨贺龙
 * @name User
 * @create 2019-11-27 9:58
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_user")
public class User extends Model<User> {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    @TableField(select = false, fill = FieldFill.INSERT)  //查询时不加入查询字段,插入数据时自动填充
    private String password;
    private String name;
    private Integer age;
    @TableField(value = "email")//指定数据表中字段名
    private String mail;

    @TableField(exist = false)//在数据表中不存在
    private String address;
    @Version //乐观锁的版本字段
    @TableField(select = false, fill = FieldFill.INSERT)
    private Integer version;
    @TableLogic //逻辑删除 1-删除 ,0-正常,未删除
    @TableField(select = false)
    private Integer deleted;

    private SexEnum sex;
}
