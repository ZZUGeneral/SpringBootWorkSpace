package com.yhl.test.mybatis_plus.test_third;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhl.test.mybatis_plus.test_third.entity.User;
import com.yhl.test.mybatis_plus.test_third.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestThirdApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(20);
        user.setMail("test@itcast.cn");
        user.setName("曹操");
        user.setUserName("caocao");
        user.setPassword("123456");
        int result = this.userMapper.insert(user); //返回的result是受影响的行数，并不是自增后的id
        System.out.println("result = > " + result);
        System.out.println("id = > " + user.getId()); //自增后的id会回填到对象中
    }

    @Test
    public void testSelectById() {
        User user = this.userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds() {
        List<User> userList = this.userMapper.selectBatchIds(Arrays.asList(1L, 3L, 6L));
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectOne() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //查询条件
        wrapper.eq("user_name", "lisi");
        //查询的结果超出一条时会抛出异常
        User user = this.userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void testUpdateById() {
        User user = new User();
        user.setId(1L); //条件,更具Id更新
        user.setAge(19);//更新的字段
        int result = this.userMapper.updateById(user);
        System.out.println("result = > " + result);
    }

    @Test
    public void testSelectCount() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", "20"); // 年龄大于20岁的user
        Integer count = this.userMapper.selectCount(wrapper);
        System.out.println("count = > " + count);
    }

    @Test
    public void testSelectList() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email", "itcast");
        List<User> userList = this.userMapper.selectList(wrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectPage() {
        Page<User> page = new Page<>(1, 2);//查询第一页,二条数据
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("email", "itcast"); // 年龄大于20岁的user
        IPage<User> iPage = this.userMapper.selectPage(page, wrapper);
        System.out.println("数据总条数: " + iPage.getTotal());
        System.out.println("数据总页数: " + iPage.getPages());
        System.out.println("当前页数: " + iPage.getCurrent());
        List<User> recodes = iPage.getRecords();
        for(User user : recodes){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setAge(20);//更新的字段
        user.setPassword("8888888");

        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("user_name", "zhangsan");
        int result = this.userMapper.update(user, wrapper);
        System.out.println("result = > " + result);
    }

    @Test
    public void testUpdate2() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("age", "21").set("password", "9999999").eq("user_name", "zhangsan");
        int result = this.userMapper.update(null, wrapper);
        System.out.println("result = > " + result);
    }

    @Test
    public void testDeleteById() {
        //根据ID删除数据
        int result = this.userMapper.deleteById(8L);
        System.out.println("result = > " + result);
    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "zhangsan");
        map.put("password", "123456");
        //根据map删除数据,多条件之间是and关系型
        int result = this.userMapper.deleteByMap(map);
        System.out.println("result = > " + result);

    }

    @Test
    public void testDelete() {
        // 用法一
       /* QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "zhangsan").eq("password", "123456");*/
        // 用法二
        User user = new User();
        user.setUserName("caocao");
        user.setPassword("123456");
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        //根据包装条件删除
        int result = this.userMapper.delete(wrapper);
        System.out.println("result = > " + result);
    }

    @Test
    public void testDeleteBatchIds() {
        int result = this.userMapper.deleteBatchIds(Arrays.asList(9L, 10L));
        System.out.println("result = > " + result);
    }

    @Test
    public void testFindById(){
        User user = this.userMapper.findById(2L);
        System.out.println(user);
    }
}
