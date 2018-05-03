package ssm.service;

import ssm.pojo.EUDataGridResult;
import ssm.pojo.TaotaoResult;
import ssm.pojo.TbItem;

/**
 * Created by HotSauce on 2018/4/10.
 */
public interface ItemService {
    /*获取商品列表*/
    EUDataGridResult getItemList(int page, int rows);

    /*插入商品信息*/
    TaotaoResult createItem(TbItem item,String desc,String itemParams) throws Exception;

    /*插入商品描述信息*/
    TaotaoResult insertItemDesc(long itemId,String desc);

}
