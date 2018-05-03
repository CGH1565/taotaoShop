package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.service.ItemParamItemService;

import javax.annotation.Resource;

/**
 * Created by HotSauce on 2018/5/3.
 */
@Controller
public class ItemParamItemController {

    @Resource
    ItemParamItemService itemParamItemService;

    @RequestMapping("/item1/{itemId}")
    public String showItemParam(@PathVariable Long itemId, Model model){
        String itemParamByItemId = itemParamItemService.getItemParamByItemId(itemId);
        model.addAttribute("itemParam",itemParamByItemId);
        return "item";
    }

}
