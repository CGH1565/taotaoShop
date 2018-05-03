package ssm.service.impl;

import org.springframework.stereotype.Service;
import ssm.dao.TbItemCatMapper;
import ssm.pojo.EasyUITreeNode;
import ssm.pojo.TbItemCat;
import ssm.pojo.TbItemCatExample;
import ssm.service.ItemCatService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HotSauce on 2018/4/23.
 */
@Service("itemCatService")
public class ItemCatServiceImpl implements ItemCatService{
    @Resource
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<EasyUITreeNode> getItemCatList(long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        List<EasyUITreeNode> easyUITreeNodes = new ArrayList<>();
        for (TbItemCat itemCat : list){
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(itemCat.getId());
            easyUITreeNode.setText(itemCat.getName());
            easyUITreeNode.setState(itemCat.getIsParent()?"closed":"open");
            easyUITreeNodes.add(easyUITreeNode);
        }
        return easyUITreeNodes;
    }
}
