package ssm.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * Created by HotSauce on 2018/4/18.
 */
public interface PictureService {
    Map uploadPicture(MultipartFile uploadFile);
}
