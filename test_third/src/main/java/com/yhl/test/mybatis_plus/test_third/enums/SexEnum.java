package com.yhl.test.mybatis_plus.test_third.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @author 杨贺龙
 * @name enums
 * @create 2019-11-25 10:45
 * @description:
 */
public enum SexEnum implements IEnum<Integer> {
    MAN(1, "男"),
    WOMAN(2, "女");

    private int value;
    private String desc;

    SexEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.desc;
    }
}
