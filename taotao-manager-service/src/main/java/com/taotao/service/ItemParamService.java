package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * Author: zhihu
 * Description:
 * Date: Create in 19:49 2018/2/6
 */
public interface ItemParamService {
        TaotaoResult getItemParamByCid(long cid);
        TaotaoResult insertItemParam(TbItemParam itemParam);
}
