package com.yhl.test.vsftpd.test;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author YHL
 * @title: Vsftpd
 * @projectName output-first
 * @description: TODO
 * @date 2020/6/269:01
 */
public class Vsftpd {
    @Test
    public void testFtpClient() throws Exception {
        //创建一个FtpClient对象
        FTPClient ftpClient = new FTPClient();
        //创建ftp连接。默认是21端口
        ftpClient.connect("192.168.18.100", 21);
        //登录ftp服务器，使用用户名和密码
        ftpClient.login("ftpuser", "ftpuser");
        //上传文件。
        //读取本地文件
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\YHL\\Pictures\\wall.jpg"));
        //设置上传的路径
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        //修改上传文件的格式 避免丢失数据
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //第一个参数：服务器端文档名
        //第二个参数：上传文档的inputStream
        ftpClient.storeFile("hello2.jpg", inputStream);
        //关闭连接
        ftpClient.logout();

    }
}