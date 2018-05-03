package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ssm.service.PictureService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by HotSauce on 2018/4/19.
 */
@Controller
public class PictureController {
    @Resource
    PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public Map pictureUpload(MultipartFile uploadFile){
        Map result = pictureService.uploadPicture(uploadFile);
        return result;
    }
}
