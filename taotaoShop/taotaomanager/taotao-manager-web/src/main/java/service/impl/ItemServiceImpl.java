package service.impl;

import dao.TbItemMapper;
import model.TbItem;
import model.TbItemExample;
import org.springframework.stereotype.Service;
import service.ItemService;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by HotSauce on 2018/4/8.
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService{
    @Resource
    private TbItemMapper tbItemMapper;
    @Override
    public TbItem getItemById(long itemId) {
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> tbItems = tbItemMapper.selectByExample(example);
        if(tbItems!=null&&tbItems.size()>0){
            TbItem tbItem = tbItems.get(0);
            return tbItem;
        }
        return null;
    }
}
