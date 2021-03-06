package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by HotSauce on 2018/4/9.
 */
/*页面跳转controller*/
@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    /*展示其他页面*/
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
