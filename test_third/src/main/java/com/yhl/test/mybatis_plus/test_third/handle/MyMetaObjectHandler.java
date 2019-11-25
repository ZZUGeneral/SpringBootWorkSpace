package com.yhl.test.mybatis_plus.test_third.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author 杨贺龙
 * @name MyMetaObjectHandler
 * @create 2019-11-25 10:29
 * @description:
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    //插入数据时填充
    @Override
    public void insertFill(MetaObject metaObject) {
        //先获取到password的值,再进行判断,如果为空,就进行填充,如果不为空就不做处理
        Object password = getFieldValByName("password", metaObject);
        if (null == password) {
            setFieldValByName("password","123456",metaObject);
        }
        setFieldValByName("version",1,metaObject);
    }

    //更新数据时填充
    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
