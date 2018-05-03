package ssm.service.impl;

import org.springframework.stereotype.Service;
import ssm.dao.TbItemParamItemMapper;
import ssm.pojo.TbItemParamItem;
import ssm.pojo.TbItemParamItemExample;
import ssm.service.ItemParamItemService;
import ssm.service.ItemParamService;
import ssm.utils.JsonUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by HotSauce on 2018/5/3.
 */
@Service("itemParamItemService")
public class ItemParamItemServiceImpl implements ItemParamItemService{
    @Resource
    TbItemParamItemMapper itemParamItemMapper;
    @Override
    public String getItemParamByItemId(Long itemId) {
        TbItemParamItemExample tbItemParamItemExample = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = tbItemParamItemExample.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<TbItemParamItem> tbItemParamItems = itemParamItemMapper.selectByExampleWithBLOBs(tbItemParamItemExample);
        if(tbItemParamItems==null||tbItemParamItems.size()==0){
            return "";
        }
        TbItemParamItem itemParamItem = tbItemParamItems.get(0);
        String paramData = itemParamItem.getParamData();
        List<Map> paramList = JsonUtils.jsonToList(paramData, Map.class);
        StringBuffer sb = new StringBuffer();
        sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
        sb.append("    <tbody>\n");
        for (Map map : paramList) {
            sb.append("        <tr>\n");
            sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+map.get("group")+"</th>\n");
            sb.append("        </tr>\n");
            List<Map> params = (List<Map>) map.get("params");
            for (Map map2 : params) {
                sb.append("        <tr>\n");
                sb.append("            <td class=\"tdTitle\">"+map2.get("k")+"</td>\n");
                sb.append("            <td>"+map2.get("v")+"</td>\n");
                sb.append("        </tr>\n");
            }
        }
        sb.append("    </tbody>\n");
        sb.append("</table>");
        return sb.toString();
    }
}