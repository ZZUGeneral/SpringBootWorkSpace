1. 安装vsftpd,关闭匿名访问,创建ftpuser用户
2. 安装nginx并修改server
3. 防火墙
4. getsebool -a | grep ftp 
    setsebool -P allow_ftpd_full_access on
    setsebool -P ftp_home_dir on
5. 使用文件上传的目录,注意ftpuser的权限