package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import ssm.dao.TbItemDescMapper;
import ssm.dao.TbItemMapper;
import ssm.dao.TbItemParamItemMapper;
import ssm.pojo.*;
import ssm.service.ItemService;
import ssm.utils.IDUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by HotSauce on 2018/4/10.
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService{
    /**
     *查询商品列表
     */
    @Resource
    TbItemMapper tbItemMapper;
    @Resource
    TbItemDescMapper tbItemDescMapper;
    @Resource
    TbItemParamItemMapper tbItemParamItemMapper;
    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        TbItemExample tbItemExample = new TbItemExample();
        PageHelper.startPage(page,rows);
        List<TbItem> tbItems = tbItemMapper.selectByExample(tbItemExample);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(tbItems);
        PageInfo pageInfo = new PageInfo(tbItems);
        euDataGridResult.setTotal(pageInfo.getTotal());
        return euDataGridResult;
    }

    /**
     * 插入商品信息
     */
    @Override
    public TaotaoResult createItem(TbItem item,String desc,String itemParams ) throws Exception {
        //item补全
        //生成商品ID
        long itemId = IDUtils.genItemId();
        item.setId(itemId);
        item.setCid((long) 650);
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        tbItemMapper.insert(item);
        TaotaoResult result = insertItemDesc(itemId, desc);
        if(result.getStatus() != 200){
            throw new Exception();
        }
        TaotaoResult result1 = insertItemParam(itemId,itemParams);
        if(result1.getStatus() != 200){
            throw new Exception();
        }
        return TaotaoResult.ok();
    }

    /**
     * 插入商品描述信息
     */
    public TaotaoResult insertItemDesc(long itemId,String desc){
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        tbItemDescMapper.insert(tbItemDesc);
        return TaotaoResult.ok();
    }

    public TaotaoResult insertItemParam(long itemId,String itemParams){
        TbItemParamItem itemParamItem = new TbItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(itemParams);
        itemParamItem.setCreated(new Date());
        itemParamItem.setUpdated(new Date());
        tbItemParamItemMapper.insert(itemParamItem);
        return TaotaoResult.ok();
    }
}
