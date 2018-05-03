package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.pojo.TaotaoResult;
import ssm.pojo.TbItemParam;
import ssm.service.ItemParamService;

import javax.annotation.Resource;

/**
 * Created by HotSauce on 2018/4/28.
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    @Resource
    private ItemParamService itemParamService;

    @RequestMapping("/query/itemcatid/{itemCatId}")
    @ResponseBody
    public TaotaoResult getItemParamByCid(@PathVariable Long itemCatId){
        TaotaoResult itemParamByCid = itemParamService.getItemParamByCid(itemCatId);
        return itemParamByCid;
    }


    @RequestMapping("/save/{cid}")
    @ResponseBody
    public TaotaoResult insertItemParam(@PathVariable Long cid,String paramData){
        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setItemCatId(cid);
        tbItemParam.setParamData(paramData);
        TaotaoResult taotaoResult = itemParamService.insertItemParam(tbItemParam);
        return taotaoResult;
    }

}
