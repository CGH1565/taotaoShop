import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import ssm.utils.FtpUtil;
import sun.net.ftp.impl.FtpClient;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by HotSauce on 2018/4/18.
 */
public class FTPTest {
    @Test
    public void testFtpClient() throws Exception{
        /*//创建一个FTP客户端
        FTPClient ftpClient = new FTPClient();
        //创建FTP连接
        ftpClient.connect("10.10.10.19",21);
        //登陆FTP服务器，使用用户名和密码
        ftpClient.login("ftpuser","xiaobu0215");
        //上传文件
        //读取本地文件
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\HotSauce\\Desktop\\1.jpg"));
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        //关闭连接
        //设置上传的文件格式
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //第一个是服务端的文件名
        ftpClient.storeFile("eason.jpg",fileInputStream);
        ftpClient.logout();*/

        FtpUtil.uploadFile("10.10.10.19",21,"ftpuser","xiaobu0215","/home/ftpuser/www/images","2018/4/18","eason.jpg",new FileInputStream(new File("C:\\Users\\HotSauce\\Desktop\\1.jpg")));
    }
}
