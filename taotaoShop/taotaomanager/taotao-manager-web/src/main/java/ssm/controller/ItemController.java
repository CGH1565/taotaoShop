package ssm.controller;
//
import org.springframework.web.bind.annotation.RequestMethod;
import ssm.pojo.EUDataGridResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.pojo.TaotaoResult;
import ssm.pojo.TbItem;
import ssm.service.ItemService;
import javax.annotation.Resource;

/**
 * Created by HotSauce on 2018/4/8.
 */
@Controller
public class ItemController {
    @Resource
    public ItemService itemService;

    @RequestMapping("/item/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows){
        EUDataGridResult itemList = itemService.getItemList(page, rows);
        return itemList;
    }

    @RequestMapping(value = "/item/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createItem(TbItem tbItem,String desc,String itemParams){
        TaotaoResult item = null;
        try {
            item = itemService.createItem(tbItem,desc,itemParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}
