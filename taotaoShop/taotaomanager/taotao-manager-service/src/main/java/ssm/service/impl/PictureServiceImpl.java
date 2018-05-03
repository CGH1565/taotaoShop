package ssm.service.impl;

import org.apache.ibatis.mapping.ResultMap;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ssm.service.PictureService;
import ssm.utils.FtpUtil;
import ssm.utils.IDUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HotSauce on 2018/4/18.
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService{
    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private int FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    @Override
    public Map uploadPicture(MultipartFile uploadFile) {
        Map resultMap = new HashMap();
        //获取原文件名
        String oldName = uploadFile.getOriginalFilename();
        //生成新文件名
        String newName = IDUtils.genImageName();
        newName = newName + oldName.substring(oldName.lastIndexOf("."));
        //图片上传
        try {
            boolean result = FtpUtil.uploadFile(FTP_ADDRESS,FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, new DateTime().toString("yyyy/MM/dd"), newName, uploadFile.getInputStream());
            System.out.println(result);
            if(!result){
                resultMap.put("error",1);
                resultMap.put("message","文件上传失败");

            }else {
                resultMap.put("error",0);
                resultMap.put("url",IMAGE_BASE_URL+"/"+newName);
            }
        } catch (IOException e) {
            resultMap.put("error",1);
            resultMap.put("message","文件上传异常");
            return resultMap;
        }
        //返回结果
        return resultMap;
    }
}
