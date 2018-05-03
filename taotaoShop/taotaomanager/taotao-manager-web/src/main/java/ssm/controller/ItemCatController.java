package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.pojo.EasyUITreeNode;
import ssm.service.ItemCatService;

import javax.annotation.Resource;
import javax.naming.Name;
import java.util.List;

/**
 * Created by HotSauce on 2018/4/23.
 */
@Controller
public class ItemCatController {

    @Resource
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value="id",defaultValue = "0") Long parentId){
        List<EasyUITreeNode> list = itemCatService.getItemCatList(parentId);
        return list;

    }
}
