package ssm.service.impl;

import org.springframework.stereotype.Service;
import ssm.dao.TbItemParamItemMapper;
import ssm.dao.TbItemParamMapper;
import ssm.pojo.TaotaoResult;
import ssm.pojo.TbItemParam;
import ssm.pojo.TbItemParamExample;
import ssm.service.ItemParamService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by HotSauce on 2018/4/28.
 */
@Service("itemParamService")
public class ItemParamServiceImpl implements ItemParamService {

    @Resource
    private TbItemParamMapper tbItemParamMapper;
    @Override
    public TaotaoResult getItemParamByCid(long cid) {
        TbItemParamExample tbItemParamExample = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = tbItemParamExample.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> tbItemParams = tbItemParamMapper.selectByExampleWithBLOBs(tbItemParamExample);
        if(tbItemParams != null&&tbItemParams.size()>0){
            return TaotaoResult.ok(tbItemParams.get(0));
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertItemParam(TbItemParam tbItemParam) {
        tbItemParam.setCreated(new Date());
        tbItemParam.setUpdated(new Date());
        tbItemParamMapper.insert(tbItemParam);
        return TaotaoResult.ok();
    }
}
