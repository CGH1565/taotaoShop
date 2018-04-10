package ssm.service.impl;

import ssm.dao.TbItemMapper;
import ssm.model.TbItem;
import ssm.model.TbItemExample;
import org.springframework.stereotype.Service;
import ssm.service.ItemService;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by HotSauce on 2018/4/8.
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService{
    @Resource
    public TbItemMapper tbItemMapper;
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
