package ssm.service;

import ssm.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by HotSauce on 2018/4/23.
 */
public interface ItemCatService {
    List<EasyUITreeNode> getItemCatList(long parentId);
}
