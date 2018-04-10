package ssm.controller;

import ssm.model.TbItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.service.ItemService;

import javax.annotation.Resource;

/**
 * Created by HotSauce on 2018/4/8.
 */
@Controller
public class ItemController {
    @Resource
    public ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem itemById = itemService.getItemById(itemId);
        return itemById;
    }

}
