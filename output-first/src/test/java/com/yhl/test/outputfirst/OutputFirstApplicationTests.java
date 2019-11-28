package com.yhl.test.outputfirst;

import com.yhl.test.outputfirst.entity.User;
import com.yhl.test.outputfirst.mapper.UserMapper;
import com.yhl.test.outputfirst.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OutputFirstApplicationTests {
@Autowired
    UserMapper userMapper;
    @Test
    public void testSelect() {

        List<User> userList = userMapper.selectList(null);
        for(User user1 : userList)
            System.out.println(user1);
    }
@Test
    public void testOut(){
    //获取数据
    List<User> list = userMapper.selectList(null);
    //excel标题
    String[] title = {"id","user_name","name","age","email","sex"};
    //excel文件名
    String filename = "信息表" + System.currentTimeMillis() + ".xls";
    //sheet名
    String sheetname = "用户信息表";

    String[][] content = new String[list.size()][];
    for(int i = 0; i < list.size();i++){
        content[i] = new String[title.length];
        User user1 = list.get(i);
        content[i][0] = user1.getId().toString();
        content[i][1] = user1.getUserName();
        content[i][2] = user1.getName();
        content[i][3] = user1.getAge().toString();
        content[i][4] = user1.getMail();
        content[i][5] = user1.getSex().toString();
    }
    //创建HSSFWorkbook
    HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetname,title,content,null);
    //响应到客户端
    try {
        File file = new File("C:\\Users\\YHL\\Desktop\\"+filename);
        OutputStream os = new FileOutputStream(file);
        wb.write(os);
        os.flush();
        os.close();
    }catch (Exception e){
        e.printStackTrace();
    }
}
}
