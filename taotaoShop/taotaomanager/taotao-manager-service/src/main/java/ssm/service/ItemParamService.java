package ssm.service;

import ssm.pojo.TaotaoResult;
import ssm.pojo.TbItemParam;

/**
 * Created by HotSauce on 2018/4/28.
 */
public interface ItemParamService {
     TaotaoResult getItemParamByCid(long cid);

     TaotaoResult insertItemParam(TbItemParam tbItemParam);
}
